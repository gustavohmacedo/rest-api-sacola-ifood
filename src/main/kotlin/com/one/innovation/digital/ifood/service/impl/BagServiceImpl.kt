package com.one.innovation.digital.ifood.service.impl

import com.one.innovation.digital.ifood.dto.*
import com.one.innovation.digital.ifood.entity.Bag
import com.one.innovation.digital.ifood.entity.Item
import com.one.innovation.digital.ifood.enumeration.PaymentType
import com.one.innovation.digital.ifood.exception.BagNotFoundException
import com.one.innovation.digital.ifood.exception.ClosedBagException
import com.one.innovation.digital.ifood.exception.EmptyBagException
import com.one.innovation.digital.ifood.repository.BagRepository
import com.one.innovation.digital.ifood.repository.ItemRepository
import com.one.innovation.digital.ifood.service.BagService
import com.one.innovation.digital.ifood.service.ItemService
import com.one.innovation.digital.ifood.service.ProductService
import org.springframework.stereotype.Service

@Service
class BagServiceImpl(
    private val bagRepository: BagRepository,
    private val productService: ProductService,
    private val itemRepository: ItemRepository,
    private val itemService: ItemService
) : BagService {

    override fun addItem(itemRequestDTO: ItemRequestDTO): ItemResponseDTO {
        val bag = this.findBagById(itemRequestDTO.bagId)
        val product = productService.findProductById(itemRequestDTO.productId)
        val itemToInsert = Item(
            product = product,
            amount = itemRequestDTO.amount,
            bag = bag.toBagEntity()
        )
        if (bag.isClosedBag!!) {
            throw ClosedBagException("The bag is closed! You can not add items.")
        }
        val bagItems: MutableList<Item> = bag.toBagEntity().items!!
        if (bagItems.isEmpty()) {
            bagItems.add(itemToInsert)
        } else {
            val currentRestaurant = bagItems.first().product.restaurant
            val itemRestaurantToInsert = itemToInsert.product.restaurant
            if (currentRestaurant == itemRestaurantToInsert) {
                bagItems.add(itemToInsert)
            } else {
                throw Exception("You can not add products from different restaurants. Close the bag or empty it!")
            }

        }

        bag.bagTotalAmount += itemToInsert.product.productPrice * itemToInsert.amount
        bagRepository.save(bag.toBagEntity())
        itemRepository.save(itemToInsert)
        return itemToInsert.toItemResponseDTO()
    }

    override fun findBagById(bagId: Long): BagResponseDTO {
        val bagOptional = bagRepository.findById(bagId)
        if (bagOptional.isEmpty) {
            throw BagNotFoundException("Bag not found")
        }

        return bagOptional.get().toBagResponseDTO()
    }

    override fun closeBagById(bagId: Long, paymentType: String): CloseBagResponseDTO {
        val bag = this.findBagById(bagId)
        if (bag.toBagEntity().items?.isEmpty()!!) {
            throw EmptyBagException("The bag is empty! To close the bag first you must add items")
        }
        val paymentType = if (paymentType == "CARD") PaymentType.CARD else PaymentType.CASH
        bag.paymentType = paymentType
        bag.isClosedBag = true

        bagRepository.save(bag.toBagEntity())
        return bag.toBagEntity().toCloseBagResponseDTO()
    }

    override fun removeItemFromBagById(itemId: Long): BagResponseDTO {

        val item = itemService.findItemById(itemId)

        if (item.bag.items?.isEmpty()!!) {
            throw EmptyBagException("The bag is empty!")
        }

        if (this.isClosedBag(item.bag)) {
            throw ClosedBagException("The bag is closed! You can not remove items.")
        }

        val itemToRemove = Item(
            itemId = item.itemId,
            product = item.product,
            amount = item.amount,
            bag = item.bag
        )

        val bagItems: MutableList<Item> = item.bag.items!!
        bagItems.remove(itemToRemove)

        itemRepository.save(itemToRemove)
        bagRepository.save(item.bag)
        return item.bag.toBagResponseDTO()
    }

    private fun isClosedBag(bag: Bag): Boolean {
        if (bag.isClosedBag!!) return true
        return false
    }


}
package com.one.innovation.digital.ifood.controller

import com.one.innovation.digital.ifood.dto.BagResponseDTO
import com.one.innovation.digital.ifood.dto.CloseBagResponseDTO
import com.one.innovation.digital.ifood.dto.ItemRequestDTO
import com.one.innovation.digital.ifood.dto.ItemResponseDTO
import com.one.innovation.digital.ifood.service.BagService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ifood-bags")
class BagController(
    private val bagService: BagService,
) {
    @PostMapping("/add-items")
    fun addItemToBag(
        @RequestBody itemRequestDTO: ItemRequestDTO,
    ): ResponseEntity<ItemResponseDTO> {

        return ResponseEntity.status(HttpStatus.OK)
            .body((bagService.addItem(itemRequestDTO)))
    }

    @GetMapping("/show-bag/{bagId}")
    fun showBagById(
        @PathVariable bagId: Long
    ): ResponseEntity<BagResponseDTO> {

        return ResponseEntity.status(HttpStatus.OK)
            .body(bagService.findBagById(bagId))
    }

    @PatchMapping("/close-bag/{bagId}")
    fun closeBag(
        @PathVariable bagId: Long,
        @RequestParam(required = true) paymentType: String,
    ): ResponseEntity<CloseBagResponseDTO> {

        return ResponseEntity.status(HttpStatus.OK)
            .body(bagService.closeBagById(bagId, paymentType))
    }

    @DeleteMapping("/remove-items/{itemId}")
    fun removeItemFromBag(
        @PathVariable(required = true) itemId: Long
    ): ResponseEntity<Any> {

        bagService.removeItemFromBagById(itemId)
        return ResponseEntity.status(HttpStatus.OK)
            .body("Item removed successfully!");
    }
}
package br.com.devleo.contagora.dto;

import java.math.BigDecimal;

public record PurchaseDTO(String description, BigDecimal amount, boolean hasInstallments, int installments, Long card_id) {
    
}

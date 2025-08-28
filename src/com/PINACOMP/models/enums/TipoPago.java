package com.PINACOMP.models.enums;

public enum TipoPago {
    FISICA("Cheque o Efectivo."),
    TARJETA("Tarjeta de credito,devito. ");
    private String pago;

    TipoPago(String pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return pago;
    }
}

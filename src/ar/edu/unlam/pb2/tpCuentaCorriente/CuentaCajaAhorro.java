package ar.edu.unlam.pb2.tpCuentaCorriente;

public class CuentaCajaAhorro extends Cuenta {

//	Similar a la anterior, pero se pide que luego de la quinta extracci�n de dinero se 
//	cobre un costo adicional por extracci�n de $ 6

	private Integer contadorExtracciones;

	// Las cajas de ahorro no pueden tener saldo negativo

	public CuentaCajaAhorro(Integer cbu, Double saldo) {
		super(cbu, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean extraerDinero(Double monto) {
		Boolean extraido = false;
		Double maximoMontoAExtraer = getSaldo();
		if (this.contadorExtracciones > 5) {
			maximoMontoAExtraer = this.getSaldo() - 6.0;
		}

		if (monto <= maximoMontoAExtraer && monto <= 0) {
			if (this.contadorExtracciones < 5 && monto <= this.getSaldo()) {
				this.setSaldo(getSaldo() - monto);
			} else {
				this.setSaldo(getSaldo() - monto - 6.0);
			}
			extraido = true;
			this.contadorExtracciones++;
		}

		return extraido;
	}

}
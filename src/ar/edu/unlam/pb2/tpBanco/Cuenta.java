package ar.edu.unlam.pb2.tpBanco;

public abstract class Cuenta implements Comparable<Cuenta>{
	private TipoCuenta tc;
	private static Integer CBU_SIGUIENTE = 1;
	private Integer cbu;
	private Double saldo;
	private Cliente propietario;
	
	
	public Cuenta(Cliente propietario, Banco bancoAlQuePertenece) {
		super();
		this.saldo = 0.0;
		this.propietario = propietario;
		this.cbu = CBU_SIGUIENTE;
		CBU_SIGUIENTE++;
		this.propietario.setCuenta(this);
	}

	public int compareTo(Cuenta aComparar) {
		return this.getCbu().compareTo(aComparar.getCbu());
	}
	
	public int compareTo(Integer cbu) {
		return this.getCbu().compareTo(cbu);
	}
	
	//todas las cuentas van a saber extraer
	//con el abstract estan obligadas a sobreescribir el metodo
	
	public abstract Boolean extraerDinero(Double monto);
	
	public Boolean depositarDinero(Double monto) {
		Boolean depositado = false;
		if (monto>0) {
			this.saldo+=monto;
			depositado = true;
		}
		return depositado;
	}

	public TipoCuenta getTc() {
		return tc;
	}

	public void setTc(TipoCuenta tc) {
		this.tc = tc;
	}

	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return this.propietario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cbu == null) ? 0 : cbu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (cbu == null) {
			if (other.cbu != null)
				return false;
		} else if (!cbu.equals(other.cbu))
			return false;
		return true;
	}
	
}

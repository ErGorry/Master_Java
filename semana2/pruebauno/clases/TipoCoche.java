package semana2.pruebauno.clases;

public enum TipoCoche {
	COUPE(4), SEDAN(5), CABRIO(2), MONOVOLUMEN(7);

	int plazas;

	TipoCoche(int plazas) {
		this.plazas = plazas;
	}
}

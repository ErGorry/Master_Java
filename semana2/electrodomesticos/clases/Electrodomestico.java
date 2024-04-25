package semana2.electrodomesticos.clases;

import semana2.electrodomesticos.interfaz.Comprable;

/**
 * 
 * @author Admin 15-04-2024
 *
 */
public class Electrodomestico{

	private static final double PRECIO_DEFECTO = 100;
	private static final Color COLOR_DEFECTO = Color.BLANCO;
	private static final ConsumoEnergetico CONSUMO_ENERGETICO_DEFECTO = ConsumoEnergetico.F;
	private static final double PESO_DEFECTO = 5;

	private double precioBase;
	private Color color;
	private ConsumoEnergetico consumo;
	private double peso;

	public Electrodomestico() {
		super();
		this.precioBase = PRECIO_DEFECTO;
		this.color = COLOR_DEFECTO;
		this.consumo = CONSUMO_ENERGETICO_DEFECTO;
		this.peso = PESO_DEFECTO;
	}

	public Electrodomestico(double precio, double peso) {
		super();
		this.precioBase = precio;
		this.color = COLOR_DEFECTO;
		this.consumo = CONSUMO_ENERGETICO_DEFECTO;
		this.peso = peso;
	}

	public Electrodomestico(double precio, String color, char consumo, double peso) {
		super();
		this.precioBase = precio;
		this.color = comprobarColor(color);
		this.consumo = comprobarConsumo(consumo);
		this.peso = peso;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public Color getColor() {
		return color;
	}

	public ConsumoEnergetico getConsumo() {
		return consumo;
	}

	public double getPeso() {
		return peso;
	}

	private ConsumoEnergetico comprobarConsumo(char letra) {

		for (ConsumoEnergetico consumo : ConsumoEnergetico.values()) {
			if (consumo.toString().equalsIgnoreCase(letra + "")) {
				return consumo;
			}
		}
		return CONSUMO_ENERGETICO_DEFECTO;

	}

	private Color comprobarColor(String color2) {

		for (Color color : Color.values()) {
			if (color2.equalsIgnoreCase(color.toString())) {
				return color;
			}
		}
		return COLOR_DEFECTO;
	}

	public double precioFinal() {
		if (peso >= 80) {
			return precioBase + consumo.getPrecio() + 100;
		} else if (peso >= 50) {
			return precioBase + consumo.getPrecio() + 80;
		} else if (peso >= 20) {
			return precioBase + consumo.getPrecio() + 50;
		}
		return precioBase + consumo.getPrecio() + 10;
	}

}

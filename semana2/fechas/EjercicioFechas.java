package semana2.fechas;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * 
 * @author Admin 18-04-2024
 *
 */
public class EjercicioFechas {

	public static void main(String[] args) {

		fechaActual();
		fechaHoraActual();
		fechaHoraZona();
		formatearFecha();
		indicarNombreYNumeroMes();
		esBisiesto();
		comprobarDia();
		sumarDias();
		sumarMeses();
		cuantosDiasPasaron();
		cuantosMesesPasaron();
		cuantosAnhosPasaron();
		cuantasHorasPasaron();
		calcularPeriodo();
		sumarPeriodoAUnaFecha();
		verDiaDeLaSemanaFecha();
		verDiaDeLaSemana();
		indicarNombreMesCastellano();
		verDiaDeLaSemanaFechaAntigua();
		presentarFechaDiaAnho();
		cuantosSegundosPasaron();

	}

	/**
	 * Cuantos segundos han pasado desde las 10:15 hasta las 12:30
	 */
	private static void cuantosSegundosPasaron() {
		Duration duracion = Duration.between(LocalTime.of(10, 15), LocalTime.of(12, 30));
		System.out.println("Entre las 10:15 y las 12:30 pasaron " + duracion.getSeconds() + " segundos.");

	}

	/**
	 * Presentar la fecha correspondiente al día 253 del año 1989
	 */
	private static void presentarFechaDiaAnho() {
		LocalDate fecha = LocalDate.ofYearDay(1989, 253);
		System.out.println("La fecha correspondiente es: " + fecha);
	}

	/**
	 * Ver que día de la semana era el primer día del mes de octubre de 1940
	 */
	private static void verDiaDeLaSemanaFechaAntigua() {
		LocalDate fecha = LocalDate.of(1940, 10, 1);
		System.out.println("El dia " + fecha + " fue "
				+ fecha.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES")));

	}

	/**
	 * Indicar el nombre en castellano del mes actual
	 */
	private static void indicarNombreMesCastellano() {
		LocalDate hoy = LocalDate.now();
		System.out.println(
				"El mes de " + hoy + " es " + hoy.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
	}

	/**
	 * Ver que día de la semana era hace tres días
	 */
	private static void verDiaDeLaSemana() {
		LocalDate hoy = LocalDate.now();
		LocalDate resta = hoy.minus(3, ChronoUnit.DAYS);
		System.out.println("El dia " + resta + " fue "
				+ resta.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
	}

	/**
	 * Ver que día de la semana era el 22/4/2022
	 */
	private static void verDiaDeLaSemanaFecha() {
		LocalDate fecha = LocalDate.of(2022, 4, 22);
		System.out.println("El dia " + fecha + " fue "
				+ fecha.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES")));

	}

	/**
	 * Ver que fecha sale si sumamos el periodo anterior a la fecha 12/11/2022
	 */
	private static void sumarPeriodoAUnaFecha() {
		Period periodo = Period.between(LocalDate.of(2020, 2, 3), LocalDate.of(2021, 7, 5));
		periodo = periodo.normalized();
		LocalDate fecha = LocalDate.of(2022, 11, 12);
		LocalDate fechaFinal = fecha.plus(periodo);
		System.out.println("La fecha resultante de " + fecha + " mas periodo " + periodo + " --> " + fechaFinal);

	}

	/**
	 * Calcular el periodo que existe entre 3/2/2020 y el 5/7/2021
	 */
	private static void calcularPeriodo() {
		LocalDate fecha1 = LocalDate.of(2020, 2, 3);
		LocalDate fecha2 = LocalDate.of(2021, 7, 5);
		Period periodo = Period.between(fecha1, fecha2);
		periodo = periodo.normalized();
		String cadena = String.format("%d Años, %d meses, %d dias", periodo.getYears(), periodo.getMonths(),
				periodo.getDays());
		System.out.println("Entre " + fecha1 + " y " + fecha2 + " hay " + cadena);

	}

	/**
	 * Calcular cuantos años han pasado entre el 7/10/2001 y el 10/5/2004
	 */
	private static void cuantosAnhosPasaron() {
		LocalDate fecha1 = LocalDate.of(2001, 10, 7);
		LocalDate fecha2 = LocalDate.of(2004, 5, 10);
		Period periodo = Period.between(fecha1, fecha2);
		int anhos = periodo.getYears();
		System.out.println("Entre " + fecha1 + " y " + fecha2 + " hay " + anhos + " años.");

	}

	/**
	 * Calcular cuantos meses han pasado entre el 7/10/2001 y el 10/5/2004
	 */
	private static void cuantosMesesPasaron() {
		LocalDate fecha1 = LocalDate.of(2001, 10, 7);
		LocalDate fecha2 = LocalDate.of(2004, 5, 10);
		Period periodo = Period.between(fecha1, fecha2);
		long meses = periodo.toTotalMonths();
		System.out.println("Entre " + fecha1 + " y " + fecha2 + " hay " + meses + " meses.");

	}

	/**
	 * Calcular cuantas horas han pasado entre el 7/10/2001 y el 10/5/2004
	 */
	private static void cuantasHorasPasaron() {
		LocalDateTime fecha1 = LocalDateTime.of(2001, 10, 7, 0, 0);
		LocalDateTime fecha2 = LocalDateTime.of(2004, 5, 10, 0, 0);
		Duration duracion = Duration.between(fecha1, fecha2);
		long horas = duracion.getSeconds() / 3600;
		System.out.println("Entre " + fecha1 + " y " + fecha2 + " hay " + horas + " horas.");
	}

	/**
	 * Calcular cuantos días han pasado entre el 7/10/2001 y el 10/5/2004
	 */
	private static void cuantosDiasPasaron() {
		LocalDateTime fecha1 = LocalDateTime.of(2001, 10, 7, 0, 0);
		LocalDateTime fecha2 = LocalDateTime.of(2004, 5, 10, 0, 0);
		Duration duracion = Duration.between(fecha1, fecha2);
		long dias = duracion.toDays();
		System.out.println("Entre " + fecha1 + " y " + fecha2 + " hay " + dias + " dias.");

	}

	/**
	 * Ver que fecha es 1 mes después del 15/12/2009
	 */
	private static void sumarMeses() {
		LocalDate fecha = LocalDate.of(2009, 12, 15);
		System.out.println("Fecha sumando 30 dias: " + fecha + " --> " + fecha.plus(30, ChronoUnit.DAYS));

	}

	/**
	 * Ver que fecha es 30 días después del 20/2/2010
	 */
	private static void sumarDias() {
		LocalDate fecha = LocalDate.of(2020, 2, 20);
		System.out.println("Fecha sumando 30 dias: " + fecha + " --> " + fecha.plus(30, ChronoUnit.DAYS));

	}

	/**
	 * Comprobar si puedo poner el dia 29 a 2/2020
	 */
	private static void comprobarDia() {
		try {
			LocalDate fecha = LocalDate.of(2020, 2, 29);
			System.out.println("Si, se ha establecido la fecha: " + fecha);
		} catch (DateTimeException dTE) {
			System.out.println("No se puede poner esa fecha: " + dTE.getMessage());
		}

	}

	/**
	 * Comprobar si el año 2022 es bisiesto
	 */
	private static void esBisiesto() {
		LocalDate year = LocalDate.of(2022, 5, 5);
		String cadena = year.isLeapYear() ? "Si, es bisiesto" : "No, no es bisiesto";
		System.out.println("El año " + year.getYear() + " es bisiesto? " + cadena);

	}

	/**
	 * Indicar a que mes corresponde el 7/12/2020, en numero y el nombre
	 */
	private static void indicarNombreYNumeroMes() {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM LLLL");
		DateTimeFormatter formateadorCastellano = formateador.withLocale(Locale.forLanguageTag("es-ES"));
		LocalDate fecha = LocalDate.of(2020, 12, 7);
		System.out.println("El mes indicado es: " + formateadorCastellano.format(fecha));

	}

	/**
	 * Devolver una fecha en formato dd/mm/yyyy
	 */
	private static void formatearFecha() {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = LocalDate.of(2022, 12, 10);
		System.out.println("Fecha con formato: " + formateador.format(fecha));

	}

	private static void fechaHoraZona() {
		ZoneId madrid = ZoneId.of("Europe/Madrid");
		ZonedDateTime fechaHoraMadrid = ZonedDateTime.now(madrid);
		System.out.println("Fecha y hora en Madrid: " + fechaHoraMadrid);

	}

	/**
	 * Presenta la fecha y la hora actual
	 */
	private static void fechaHoraActual() {
		LocalDateTime fechaHora = LocalDateTime.now();
		System.out.println("Fecha y hora actual: " + fechaHora);

	}

	/*
	 * Presenta la fecha actual
	 */
	private static void fechaActual() {
		LocalDate fecha = LocalDate.now();
		System.out.println("Fecha actual: " + fecha);

	}

}

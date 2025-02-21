package ec.webmarket.restful.common;

public final class ApiConstants {

	private ApiConstants() {
	}

	public static final String URI_API_V1 = "/api/v1.0/";

	// Nuevas rutas
	public static final String URI_API_V1_PACIENTE = URI_API_V1 + "paciente";
	public static final String URI_API_V1_ODONTOLOGO = URI_API_V1 + "odontologo";
	public static final String URI_API_V1_HORARIO = URI_API_V1 + "horario";
	public static final String URI_API_V1_CITA = URI_API_V1 + "cita";
	
	// Estados de las citas
	public static final String ESTADO_PENDIENTE = "Pendiente";
	public static final String ESTADO_CONFIRMADA = "Confirmada";
	public static final String ESTADO_CANCELADA = "Cancelada";
}


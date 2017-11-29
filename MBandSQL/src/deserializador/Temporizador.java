package deserializador;

	public final class Temporizador {

		private static long startValue;
		private static long stopValue;
		private static long diferencaTempo;

		public void start() {
			startValue = System.currentTimeMillis();
			stopValue = 0;
			diferencaTempo = 0;
		}

		public void stop() {
			stopValue = System.currentTimeMillis();
			diferencaTempo = stopValue - startValue;
		}

		public static long tempoMilissegundos() {
			return diferencaTempo;
		}
		
		public static double tempoSegundos() {
			return diferencaTempo/1000;
		}

		public static long getStartValue() {
			return startValue;
		}

		public static void setStartValue(long startValue) {
			Temporizador.startValue = startValue;
		}

		public static long getStopValue() {
			return stopValue;
		}

		public static void setStopValue(long stopValue) {
			Temporizador.stopValue = stopValue;
		}

		public static long getDiferencaTempo() {
			return diferencaTempo;
		}

		public static void setDiferencaTempo(long diferencaTempo) {
			Temporizador.diferencaTempo = diferencaTempo;
		}
		
		
		
		
}



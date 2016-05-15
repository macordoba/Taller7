package conceptosAvanzados;

import junit.framework.TestCase;

/**
@author Alvaro Cordoba.
@version V 1.0
@since 13/05/2016.
*/

/**
Clase que prueba la clase calcularIndicadores
*/


public class AppTest extends TestCase{
  
	/**
	Metodo que prueba primer caso de prueba
	*/
	
    public void testCaso1()
    {
    	int[] valoresXint= {130, 650, 99, 150, 128, 302, 95, 945, 368, 961};
		int[] valoresYint= {186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601};    	
		CalcularIndicadores objectopruebas = new CalcularIndicadores();
		
		objectopruebas.setValoresX(valoresXint);
		objectopruebas.setValoresY(valoresYint);
		objectopruebas.setXk(386);
		objectopruebas.setP(0.35);
		objectopruebas.calcularIndicadores();
				
		assertEquals(-22.55253D, objectopruebas.getB0(), 0.00001D);
		assertEquals(1.72793D, objectopruebas.getB1(), 0.00001D);
		assertEquals(0.95449D, objectopruebas.getR(), 0.00001D);
		assertEquals(0.0000177517D, objectopruebas.getSignificancia(), 0.00000001D);
		assertEquals(414.42766D, objectopruebas.getLPI(), 0.001D);
		assertEquals(874.431103D, objectopruebas.getUPI(), 0.001D);
		assertEquals(230.00171D, objectopruebas.getRango(), 0.001D);
		assertEquals(0.91106D, objectopruebas.getR2(), 0.00001D);
		assertEquals(644.42938D, objectopruebas.getYk(), 0.00001D);
    }
    
    /**
	Metodo que prueba segundo caso de prueba
	*/
    
    public void testCaso2()
    {
    	int[] valoresXint= {130, 650, 99, 150, 128, 302, 95, 945, 368, 961};
		double[] valoresYint= {15.0, 69.9, 6.5, 22.4, 28.4, 65.9, 19.4, 198.7, 38.8, 138.2};    	
		CalcularIndicadores objectopruebas = new CalcularIndicadores();
		
		objectopruebas.setValoresX(valoresXint);
		objectopruebas.setValoresY(valoresYint);
		objectopruebas.setXk(386);
		objectopruebas.setP(0.35);
		objectopruebas.calcularIndicadores();
				
		assertEquals(-4.038881D, objectopruebas.getB0(), 0.00001D);
		assertEquals(0.1681266D, objectopruebas.getB1(), 0.00001D);
		assertEquals(0.933306D, objectopruebas.getR(), 0.00001D);
		assertEquals(0.0000798203D, objectopruebas.getSignificancia(), 0.00000001D);
		assertEquals(33.300357D, objectopruebas.getLPI(), 0.001D);
		assertEquals(88.415652D, objectopruebas.getUPI(), 0.001D);
		assertEquals(27.557647D, objectopruebas.getRango(), 0.001D);
		assertEquals(0.8710617D, objectopruebas.getR2(), 0.00001D);
		assertEquals(60.858005D, objectopruebas.getYk(), 0.00001D);
    }
}

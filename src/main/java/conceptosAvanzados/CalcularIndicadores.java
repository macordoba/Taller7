package conceptosAvanzados;

import java.util.ArrayList;

/**
@author Alvaro Cordoba.
@version V 1.0
@since 09/05/2016.
*/

/**
Clase que calcular Indicadores de un grupo de datos
*/

public class CalcularIndicadores 
{
	private double B0;
	private double B1;
	private double r2;
	private double r;
	private double xPrima;
	private double xk;
	private double significancia;
	private double numeroDatos;
	private double UPI;
	private double LPI;
	private double yk;
	private double p;
	private double rango;
	private ArrayList<Double> xi;
	private ArrayList<Double> yi;
	private final double ERROR_ACEPTABLE = 0.00000001D;
	
	public double getSignificancia() {
		return significancia;
	}

	public double getB0() {
		return B0;
	}

	public double getR2() {
		return r2;
	}

	public double getR() {
		return r;
	}

	public double getB1() {
		return B1;
	}

	public double getUPI() {
		return UPI;
	}

	public double getLPI() {
		return LPI;
	}

	public double getYk() {
		return yk;
	}

	public void setP(double p) {
		this.p = p;
	}

	public double getRango() {
		return rango;
	}
	
	public void setXk(double xk) {
		this.xk = xk;
	}

	/**
	Metodo que calcula los indicadores
	 */
	
	public void calcularIndicadores()
    {
		CalcularCoeficientes objetoCoeficientes = new CalcularCoeficientes();
		CalularIntegral objetoIntegral = new CalularIntegral();
		CalcularIntegralError objectoIntegralError = new CalcularIntegralError();
		numeroDatos = xi.size();
		
		objetoCoeficientes.setValoresX(xi); 
		objetoCoeficientes.setValoresY(yi);
		objetoCoeficientes.setXk(xk);
		objetoCoeficientes.CalcularCoeficientes();
		
		B0 = objetoCoeficientes.getB0();
		B1 = objetoCoeficientes.getB1();
		yk = objetoCoeficientes.getYk();
		r2 = objetoCoeficientes.getR2();
		r = objetoCoeficientes.getR();
		xPrima = Operaciones.calcularXSignificancia((int)numeroDatos,objetoCoeficientes.getR());
		
		objetoIntegral.setDof((int)numeroDatos-2);
		objetoIntegral.setNumSeg(28);
		objetoIntegral.setX(xPrima);
		objetoIntegral.calcularp();
		
    	significancia= 1-(2*objetoIntegral.getP());
    				
		objectoIntegralError.setError_aceptable(ERROR_ACEPTABLE);
    	objectoIntegralError.setGradosLibertdad((int)numeroDatos - 2);
    	objectoIntegralError.setP(p);
    	objectoIntegralError.calcularX();
    	
    	rango = Operaciones.calcularRango(objectoIntegralError.getX(), numeroDatos, xk, yi, xi, B0, B1);
		UPI = yk + rango;
		LPI = yk - rango;
    }
    
	public void setValoresX(int[] valoresXint)
	{
    	xi = llenar(valoresXint);		
	}
	
	public void setValoresX(double[] valoresXint)
	{
    	xi = llenar(valoresXint);		
	}
	
	public void setValoresY(double[] valoresYint)
	{
    	yi = llenar(valoresYint);		
	}
	
	public void setValoresY(int[] valoresYint)
	{
		yi = llenar(valoresYint); 		
	}
	
	

	/**
	Metodo que mapea datos de entrada los retorna en un arrayList
	@param temporal valores de entrada en Array double
	 */
	
    private ArrayList<Double> llenar(double[] temporal)
    {
    	ArrayList<Double> valores = new ArrayList<Double>();
    	
    	for(double valor : temporal)
    	{
    		valores.add(valor);
    	}
    	
    	return valores;
    }

    
    public void setValoresX(String valoresXint)
    {
    	xi = llenar(valoresXint);
    }

    public void setValoresY(String valoresYint)
    {
    	yi = llenar(valoresYint);
    }
    
	/**
	Metodo que mapea datos de entrada los retorna en un arrayList
	@param temporal valores de entrada en variable tipo String
	 */
    
    private ArrayList<Double> llenar(String temporal)
    {
    	ArrayList<Double> valores = new ArrayList<Double>();
    	int loc = temporal.indexOf('\n');
        
    	while(loc > 0){
    		valores.add(Double.parseDouble(temporal.substring(0, loc+1)));
    		temporal = temporal.substring(loc + 1);
    		loc = temporal.indexOf('\n');
       }
    	
    	return valores;
    }
        
	/**
	Metodo que mapea datos de entrada los retorna en un arrayList
	@param temporal valores de entrada en variable Array int
	 */
    
    private ArrayList<Double> llenar(int[] temporal)
    {
    	ArrayList<Double> valores = new ArrayList<Double>();
    	for(int valor : temporal)
    	{
    		valores.add((double) valor);
    	}
    	
    	return valores;
    }   
}

package com.gmail.merkat;
/**
 * Classe per definir els paràmetres i els limitadors que hi hauran a l'algorisme 
 * @author Adria i Gerard
 * @since 31-01-2014
 */
public class Utils {
	public static final int nSellStations = 5; // 5 caixes 
	public static final int nEmployees = 7;  // 7 empelats
	
	public static final int maxNProducts = 20; // tamany màxim del carro
	
	public static final int maxNQueueCustomers = 5; // tamany màxim de cua de clients per caixa
	public static final int maxNCustomers = 300; // tamany màxim de clients al merkat
	
	public static final int minTimeScan = 10; // temps minim que tarda el caixer a pasar el producte a la cinta
	public static final int maxTimeScan = 1000; // temps maxim que tarda el caixer a pasar el producte a la cinta
	
	public static final int minimeGenCustomers = 0; // temps minim per generar clients
	public static final int maxTimeGenCustomers = 1000; // temps maxim per generar clients
}

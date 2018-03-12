
package com.bancolombia.gestiontarjetas;

import org.junit.Test;

public class CreditCardTest extends BaseTest {

	@Test
	public void myTest() throws Exception {
		CreditCardPage navigation = new CreditCardPage(driver, wait);

		navigation.goToTarjetasCredito();

		navigation.saveInfoCardsExcelFile();

		navigation.applyFormAmerican();

		navigation.sendDataFormToGetCard();
	}

}

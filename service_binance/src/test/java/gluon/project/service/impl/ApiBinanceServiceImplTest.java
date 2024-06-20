package gluon.project.service.impl;


import gluon.project.service.ApiBinanceService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ApiBinanceServiceImplTest {

    @Test
    void testConnectivityTest() {
        ApiBinanceService apiBinanceService = new ApiBinanceServiceImpl();
        boolean testConnectivityOk = apiBinanceService.testConnectivity();
        assertTrue(testConnectivityOk);
    }

}
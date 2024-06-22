package gluon.project.service.impl;


import gluon.project.service.ApiBinanceService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ApiBinanceServiceImplTest {

    @Test
    void isConnectionOk_test() {
        ApiBinanceService apiBinanceService = new ApiBinanceServiceImpl();
        boolean testConnectivityOk = apiBinanceService.isConnectionOk();
        assertTrue(testConnectivityOk);
    }

}
package com.andrea.puccia;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockitoTest {

    @Mock
    private Calculator calculator;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockito() {
        when(calculator.getResult()).thenReturn(74);
        assertThat(calculator.getResult()).isEqualTo(74);
    }

}

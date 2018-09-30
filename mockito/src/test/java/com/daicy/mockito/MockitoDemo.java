package com.daicy.mockito;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;


public class MockitoDemo {

    private List mockList = Mockito.mock(List.class);
    private String listValue0 = "value1";;

    @Before
    public void setupMockMvc() {
        mockList = Mockito.mock(List.class);
        when(mockList.get(0)).thenReturn(listValue0);
    }


    @Test
    public void testListWithActualValue() {

        List<String> list = new ArrayList<String>();

        list.add(listValue0);
        assertThat(list.get(0), Matchers.equalTo(listValue0));
        assertThat(list.get(0), is(listValue0));
        assertThat(list.get(0), is("value1"));
    }

    @Test

    public void testListWithMockito() {

        assertThat(mockList.get(0).toString(), is(listValue0));
        doNothing().doThrow(new RuntimeException("void exception")).when(mockList).clear();
        mockList.clear();
//        mockList.clear();
        verify(mockList,times(2)).clear();

    }

}
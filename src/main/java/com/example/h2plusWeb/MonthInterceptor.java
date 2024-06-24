package com.example.h2plusWeb;

import com.example.h2plusWeb.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    private List<Month> monthList = Arrays.asList(
            new Month(1, "January", "Gennaio", "Januar"),
            new Month(2, "February", "Febbraio", "Februar"),
            new Month(3, "March", "Marzo", "März"),
            new Month(4, "April", "Aprile", "April"),
            new Month(5, "May", "Maggio", "Mai"),
            new Month(6, "June", "Giugno", "Juni")
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberStr = request.getHeader("monthNumber");

        if (monthNumberStr == null || monthNumberStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "monthNumber header is missing or empty");
            return false;
        }

        try {
            int monthNumber = Integer.parseInt(monthNumberStr);
            Month month = null;
            for (Month m : monthList) {
                if (m.getMonthNumber() == monthNumber) {
                    month = m;
                    break;
                }
            }
            if (month == null) {
                month = new Month(0, "nope", "nope", "nope");
            }
            request.setAttribute("month", month);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "monthNumber must be an integer");
            return false;
        }

        return true;
    }
}

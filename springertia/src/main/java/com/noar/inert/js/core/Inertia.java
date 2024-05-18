package com.noar.inert.js.core;

import org.springframework.web.servlet.ModelAndView;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Inertia {
    private static final String INERTIA_VIEW_NAME = "inertiaView";
    static ModelAndView render(String component) {
        return new ModelAndView(INERTIA_VIEW_NAME)
            .addObject("component", component);
    }

    static ModelAndView render(String component, Props props) {
        return new ModelAndView(INERTIA_VIEW_NAME)
            .addObject("component", component)
            .addObject("props", props.getContent());
    }

    public static class Props {
        private final Object content;

        private Props(Object viewModel) {
            this.content = viewModel;
        }

        public static Props with(Object viewModel) {
            return new Props(viewModel);
        }

        public Object getContent() {
            return content;
        }
    }
}

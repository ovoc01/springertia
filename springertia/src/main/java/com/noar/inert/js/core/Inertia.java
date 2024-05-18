package com.noar.inert.js.core;

import org.slf4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.noar.inert.js.core.response.InertiaResponse;

import lombok.experimental.UtilityClass;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class Inertia {
    private static final String INERTIA_VIEW_NAME = "inertiaView";
    Logger logger = org.slf4j.LoggerFactory.getLogger(Inertia.class);
    public static ModelAndView render(String component) {
        return new ModelAndView(INERTIA_VIEW_NAME)
            .addObject("component", component);
    }

    public static ModelAndView render(String component, Props props) {
        ModelAndView modelAndView = new ModelAndView(INERTIA_VIEW_NAME)
            .addObject("component", component)
            .addObject("props", props.getContent());

        logger.info("InertiaRender with {} method returned props: {}",component,modelAndView.getModel());
        return modelAndView;
    }

    

    public static class Props {
        private final Object content;

        private Props(Object viewModel) {
            this.content = viewModel;
        }

        public static Props with(Object viewModel) {
            return new Props(viewModel);
        }

        public static List<Props> mapToInertiaResponse(List<InertiaResponse> values) {
            return Collections.singletonList(new Props(values));
        }

        public Object getContent() {
            return content;
        }
    }
}

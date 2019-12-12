import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.ValidatorException;
@FacesConverter ("yConverter")
public class yConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        try {
            value = value.trim().replace(",", ".");
            double d = Double.parseDouble(value);
            return d;
        } catch (NumberFormatException ex) {
            throw new ConverterException(new FacesMessage("Должно быть введено число!"));
        }

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        return null;
    }
}

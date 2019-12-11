import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("yValidator")
public class YValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        System.out.println("Значение value в yValidator:" + value);
        if (value == null) {
            throw new ValidatorException(new FacesMessage("Это поле должно быть заполнено!"));
        }
            double newValue = ((Number) value).doubleValue();
            if (newValue > 5.0 || newValue < -5.0) {
                throw new ValidatorException(new FacesMessage("Число должно быть в диапозоне от -5.0 до 5.0"));

        }

    }
}

package App;
import java.util.Arrays;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import validador.NameValidator;
import validador.ValidatorComposite;

@Module
public class ApplicationModule {
	
	@Provides
	@Named("SaveClientValidator")
	public ValidatorComposite provideValidatorComposite(){
		return new ValidatorComposite(Arrays.asList(
					new NameValidator()
					));
	}

}

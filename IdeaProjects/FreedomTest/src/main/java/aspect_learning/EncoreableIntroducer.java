package aspect_learning;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "aspect_learning.Performance+",defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}

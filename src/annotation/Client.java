package annotation;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Request request = createInstance(Request.class);
		request.request();
	}
	
	private static <T> T createInstance(final Class<T> classQuest) {
		Util.validateServiceInterface(classQuest);
		return (T) Proxy.newProxyInstance(classQuest.getClassLoader(), new Class<?>[] { classQuest },
		        new InvocationHandler() {
		          @Override public Object invoke(Object proxy, Method method, Object[] args)
		              throws Throwable {
		            // If the method is a method from Object then defer to normal invocation.
		            if (method.getDeclaringClass() == Object.class) {
		              return method.invoke(this, args);
		            }
		            System.out.println("start time:"+System.currentTimeMillis());
		            loadMethod(method);
		            System.out.println("end time:"+System.currentTimeMillis());
		            return null;
		          }
		        });
	}
	
	private static void loadMethod(Method method) {
		try {
			Annotation[] methodAnnotations = method.getAnnotations();
			for (Annotation annotation : methodAnnotations) {
				parseMethodAnnotation(annotation);
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void parseMethodAnnotation(Annotation annotation) {
		parseHttpMethodAndPath("GET", ((GET) annotation).value(), false);
	}
	
	private static void parseHttpMethodAndPath(String httpMethod, String value, boolean hasBody) {
		System.out.println("value:"+value+" hasBody:"+hasBody);
	}
}

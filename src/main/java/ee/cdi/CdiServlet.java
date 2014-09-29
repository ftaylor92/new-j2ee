package ee.cdi;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cdiservlet")
public class CdiServlet extends HttpServlet {
    @Inject private Message message;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                  throws IOException {
        response.getWriter().write(message.get());
    }
    
    //@RequestScoped
    public class MessageB implements Message {

		@Override
		public String get() {
			// TODO Auto-generated method stub
			return null;
		}  }
}

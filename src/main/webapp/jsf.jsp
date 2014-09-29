<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html">
    <h:head>
        <title>Facelets Hello Greeting</title>
    </h:head>
    <h:body>
        <h:form>
            <!-- h:graphicImage url="pnd{resource['images:duke.waving.gif']}" alt="Duke waving his hand"/ -->
            <h:graphicImage url="img/recline.jpg" alt="Duke waving his hand"/>
            <h2>Hello, my name is Duke. What's yours?</h2>
            <h:inputText id="username"
                         title="My name is: "
                         value="#{hello.name}"
                         required="true"
                         requiredMessage="Error: A name is required."
                         maxlength="25" />
            <p></p>
            <h:commandButton id="submit" value="Submit" action="response">
            </h:commandButton>
            <h:commandButton id="reset" value="Reset" type="reset">
            </h:commandButton>
        </h:form>
        ...
    </h:body>
</html>
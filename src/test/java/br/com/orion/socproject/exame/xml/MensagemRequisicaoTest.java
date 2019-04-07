package br.com.orion.socproject.exame.xml;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import br.com.orion.socproject.exame.xml.node.MensagemRequisicaoNode;

public class MensagemRequisicaoTest {

	@Test
	public void mensagemRequisicaoTest() throws JAXBException {

		MensagemRequisicaoNode msg = new MensagemRequisicaoNode();
		msg.setCodigoTuss(1000000);

		JAXBContext jaxbContexto = JAXBContext.newInstance(MensagemRequisicaoNode.class);
		Marshaller marshaller = jaxbContexto.createMarshaller();
		StringWriter escritor = new StringWriter();
		marshaller.marshal(msg, escritor);

		String xmlGerado = escritor.toString();

		System.out.println(xmlGerado);
	}
}

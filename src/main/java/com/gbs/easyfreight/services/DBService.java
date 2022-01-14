package com.gbs.easyfreight.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.easyfreight.domain.Caminhao;
import com.gbs.easyfreight.domain.Cidade;
import com.gbs.easyfreight.domain.Cliente;
import com.gbs.easyfreight.domain.Conta;
import com.gbs.easyfreight.domain.Container;
import com.gbs.easyfreight.domain.Endereco;
import com.gbs.easyfreight.domain.Estado;
import com.gbs.easyfreight.domain.Frete;
import com.gbs.easyfreight.domain.Motorista;
import com.gbs.easyfreight.domain.Operacao;
import com.gbs.easyfreight.domain.Reboque;
import com.gbs.easyfreight.domain.Rota;
import com.gbs.easyfreight.domain.Vistoria;
import com.gbs.easyfreight.repositories.CaminhaoRepository;
import com.gbs.easyfreight.repositories.CidadeRepository;
import com.gbs.easyfreight.repositories.ClienteRepository;
import com.gbs.easyfreight.repositories.ContaRepository;
import com.gbs.easyfreight.repositories.ContainerRepository;
import com.gbs.easyfreight.repositories.EnderecoRepository;
import com.gbs.easyfreight.repositories.EstadoRepository;
import com.gbs.easyfreight.repositories.FreteRepository;
import com.gbs.easyfreight.repositories.MotoristaRepository;
import com.gbs.easyfreight.repositories.OperacaoRepository;
import com.gbs.easyfreight.repositories.ReboqueRepository;
import com.gbs.easyfreight.repositories.RotaRepository;
import com.gbs.easyfreight.repositories.VistoriaRepository;

@Service
public class DBService {
	
	
	
	
	@Autowired
	private ContaRepository contasRepository;
	
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CaminhaoRepository caminhaoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ContainerRepository containerRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private FreteRepository freteRepository;

	@Autowired
	private OperacaoRepository operacaoRepository;

	@Autowired
	private ReboqueRepository reboqueRepository;
	
	@Autowired
	private RotaRepository rotaRepository;

	@Autowired
	private VistoriaRepository vistoriaRepository;
	
	

	public void instantiateTestDatabase() throws ParseException {
		// VARIÁVEL DE FORMATAÇÃO DE DATAS
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfh = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		// MOTORISTAS
		Motorista motor1 = new Motorista(null, "Gustavo", "Bomfim ", "1111111111", sdf.parse("12/09/1996"),
				"gustavoengel01@gmail.com", "123", 312154521, sdf.parse("12/09/2031"));
		Motorista motor2 = new Motorista(null, "Alessandra", "Oliveira", "11111", sdf.parse("12/09/1996"),
				"gustavoengel01@gmail.com", "123", 312154521, sdf.parse("12/09/2031"));
		Motorista motor3 = new Motorista(null, "Silvio", "Sebastião", "11111", sdf.parse("12/09/1996"),
				"gustavoengel01@gmail.com", "123", 312154521, sdf.parse("12/09/2031"));
		Motorista motor4 = new Motorista(null, "Marcelo", "Damião", "11111", sdf.parse("12/09/1996"),
				"gustavoengel01@gmail.com", "123", 312154521, sdf.parse("12/09/2031"));
		Motorista motor5 = new Motorista(null, "Sirlene", "Aparecida", "11111", sdf.parse("12/09/1996"),
				"gustavoengel01@gmail.com", "123", 312154521, sdf.parse("12/09/2031"));
		Motorista motor6 = new Motorista(null, "Pedro", "Sampaio", "11111", sdf.parse("12/09/1996"),
				"gustavoengel01@gmail.com", "123", 312154521, sdf.parse("12/09/2031"));
		Motorista motor7 = new Motorista(null, "Claudia", "Leite", "11111", sdf.parse("12/09/1996"),
				"gustavoengel01@gmail.com", "123", 312154521, sdf.parse("12/09/2031"));
		Motorista motor8 = new Motorista(null, "Claudio", "Engel", "11111", sdf.parse("12/09/1996"),
				"gustavoengel01@gmail.com", "123", 312154521, sdf.parse("12/09/2031"));
		Motorista motor9 = new Motorista(null, "Lucas", "Lucco", "11111", sdf.parse("12/09/1996"),
				"gustavoengel01@gmail.com", "123", 312154521, sdf.parse("12/09/2031"));
		Motorista motor10 = new Motorista(null, "Fenrnando", "Sorocaba", "11111", sdf.parse("12/09/1996"),
				"gustavoengel01@gmail.com", "123", 312154521, sdf.parse("12/09/2031"));

		// CAMINHÕES
		Caminhao car1 = new Caminhao(null, "5465465465456", "GFD-9S89", "BRANCO", "SCANIA F3948", 2019, "TRUCK");
		Caminhao car2 = new Caminhao(null, "5456456465", "JJK-9S89", "AZUL", "SCANIA F3948", 2012, "TRUCK");

		car1.getMotoristas().addAll(Arrays.asList(motor1, motor2, motor5, motor6, motor7));
		car2.getMotoristas().addAll(Arrays.asList(motor2, motor3, motor4, motor7, motor8, motor9, motor10));

		motor1.getCaminhoes().addAll(Arrays.asList(car1));
		motor2.getCaminhoes().addAll(Arrays.asList(car1, car2));

		// REBOQUES
		Reboque reb1 = new Reboque(null, "654564564564", "3213213213", "2X40");

		reb1.getMotoristas().addAll(Arrays.asList(motor1));

		motor1.getReboques().addAll(Arrays.asList(reb1));

		// VISTORIAS
		Vistoria vist1 = new Vistoria(null, sdf.parse("12/09/1996"), 1, car1);
		vist1.getObservacoes().addAll(Arrays.asList("Pneu quase furando precisa trocar"));

		reboqueRepository.saveAll(Arrays.asList(reb1));
		caminhaoRepository.saveAll(Arrays.asList(car1, car2));
		motoristaRepository.saveAll(
				Arrays.asList(motor1, motor2, motor3, motor4, motor5, motor6, motor7, motor8, motor9, motor10));
		vistoriaRepository.saveAll(Arrays.asList(vist1));

		// CONTAS DE MOTORISTAS
		Conta conta1 = new Conta(null, 5522335, 00121, "43173974808", "Gustavo Bomfim", "dsfdsf", motor1);
		Conta conta2 = new Conta(null, 5522335, 00121, "43173974808", "Alessandra Saco", "dsfdsf", motor2);
		contasRepository.saveAll(Arrays.asList(conta1, conta2));

		// ESTADOS
		Estado est1 = new Estado(null, "São Paulo", "SP");
		Estado est2 = new Estado(null, "Paraná", "PR");

		// CIDADES
		Cidade cid1 = new Cidade(null, "Santos", est1);
		Cidade cid2 = new Cidade(null, "São Vicente", est1);
		Cidade cid3 = new Cidade(null, "Curitiba", est2);

		// AGRUPRA CIDADDADES POR ESTADO
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3, cid2));

		// SALVA ESTADOS
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		// CRIA CLIENTE
		Cliente cli1 = new Cliente(null, "GBS SOLUCOES EM TI", "33.365.325.01115-51", "gustavoengel01@gmail.com");
		Cliente cli2 = new Cliente(null, "Marcelo SOLUCOES EM TI", "33.365.325.01115-51", "gustavoengel01@gmail.com");
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));

		// ENDEREÇOS
		Endereco end1 = new Endereco(null, "Armando de Almeida", "140", "casa", "Jardim Novo", "11087-380", cid2, cli1,
				null);
		Endereco end2 = new Endereco(null, "Jornalista Paulo Matos", "239", "Jardim Novo", "AP64 TORRE 1", "112468-380",
				cid2, cli1, null);
		Endereco end3 = new Endereco(null, "Jornalista Paulo Matos", "239", "Jardim Novo", "AP64 TORRE 1", "112468-380",
				cid2, null, motor1);

		// ADICIONANDO ENDERECOS AOS CLIENTES
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));

		Frete frete1 = new Frete(null, "REFERENCIA 1", "2 PALLETS", 255.84, null, null, motor1, null, cli1);
		frete1.getNcms().addAll(Arrays.asList("9183", "5646"));
		freteRepository.saveAll(Arrays.asList(frete1));

		// CONTAINER
		Container cont1 = new Container(null, "GDFG6-3432/4234", 40, "HR", frete1);

		containerRepository.saveAll(Arrays.asList(cont1));

		// ROTAS
		Rota rot1 = new Rota(null, cid1, "Rua alencar 123, vila nova", cid1, "Terminal BTP", cid2,
				"Fábrica da Wolkwagem", cid1, "Terminal BTP", frete1);
		rotaRepository.saveAll(Arrays.asList(rot1));

		// OPERAÇÃO
		Operacao ope1 = new Operacao(null, sdfh.parse("12/09/1996 15:20"), sdfh.parse("12/09/1996 15:20"),
				sdfh.parse("12/09/1996 15:20"), sdfh.parse("12/09/1996 15:20"), sdfh.parse("12/09/1996 15:20"),
				sdfh.parse("12/09/1996 15:20"), sdfh.parse("12/09/1996 15:20"), sdfh.parse("12/09/1996 15:20"), frete1);

		operacaoRepository.saveAll(Arrays.asList(ope1));
	}

}

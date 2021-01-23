package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date dataFabricacao;

	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String nome, Double preco, SimpleDateFormat sdf, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	@Override
	public String etiquetaPreco() {
		return nome + " (usado) - R$ " + String.format("%.2f", preco) + " - (Data de fabricação: "
				+ sdf.format(dataFabricacao) + ")";
	}
}
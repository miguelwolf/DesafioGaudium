package br.com.gaudium.entrega.model;

import br.com.gaudium.entrega.Currency;

public class PerfilJsonObj {
	private String success;
	private PerfilObj response;

	public boolean isSuccess() {
		return "true".equalsIgnoreCase(success);
	}

	public PerfilObj getResponse() {
		return response;
	}

	public static class PerfilObj {
		private String nome;
		private String cargo;
		private String descricao;
		private HistoricoObj[] historico;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCargo() {
			return cargo;
		}

		public void setCargo(String cargo) {
			this.cargo = cargo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public HistoricoObj[] getHistorico() {
			return historico;
		}

		public int getEntregasTotal(){

			int qtd = 0;

			for (int i = 0; i < historico.length; i++) {
				qtd += historico[i].qtd;
			}

			return qtd;

		}

		public String getSaldoTotal(){

			double valor = 0.0;

			for (int i = 0; i < historico.length; i++) {
				valor += historico[i].valor;
			}

			return Currency.mascaraDinheiro(valor, Currency.DINHEIRO_REAL);

		}

		public double getNotaTotal() {

			double nota = 0.0;

			for (int i = 0; i < historico.length; i++) {
				nota += historico[i].avaliacao;
			}

			return nota/historico.length;
		}

		public void setHistorico(HistoricoObj[] historico) {
			this.historico = historico;
		}

	}

	public static class HistoricoObj {
		private String quando;
		private int qtd;
		private double valor;
		private int avaliacao;

		public HistoricoObj(String quando, int qtd, double valor, int avaliacao) {
			this.quando = quando;
			this.qtd = qtd;
			this.valor = valor;
			this.avaliacao = avaliacao;
		}

		public String getQuando() {
			return quando;
		}

		public void setQuando(String quando) {
			this.quando = quando;
		}

		public int getQtd() {
			return qtd;
		}

		public void setQtd(int qtd) {
			this.qtd = qtd;
		}

		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}

		public int getAvaliacao() {
			return avaliacao;
		}

		public void setAvaliacao(int avaliacao) {
			this.avaliacao = avaliacao;
		}
	}
}

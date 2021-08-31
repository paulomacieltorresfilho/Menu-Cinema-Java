package components;

public class Filme {
	private String id;
	private String name;
	private String description;
	private String gender;
	private int duration;
	
	public Filme(String identificacao, String nome
			, String descricao, String genero, int duracao) {
		id = identificacao;
		name = nome;
		description = descricao;
		gender = genero;
		duration = duracao;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
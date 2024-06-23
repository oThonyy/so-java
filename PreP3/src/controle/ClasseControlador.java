package controle;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ClasseControlador {
	
	private String arquivo;

    public ClasseControlador(String arquivo) {
        this.arquivo = arquivo;
    }

    public String obterLastPrice(String Symbol) {
    	
        try (FileReader reader = new FileReader(arquivo)) {
        	
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            
            for (JsonElement i : jsonArray) {
                JsonObject jsonObjeto = i.getAsJsonObject();
                
                if (jsonObjeto.get("symbol").getAsString().equalsIgnoreCase(Symbol)) {
                    return jsonObjeto.get("lastPrice").getAsString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return "Symbol nao encontrado";
    }
}

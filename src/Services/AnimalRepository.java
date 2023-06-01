package Services;

import Model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {
    public List<Animal> getAll() {
        List<Animal> farm = new ArrayList<Animal>();
        Pet pet;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = getConnection()) {
                sqlSt = dbConnection.createStatement();
                SQLstr = "SELECT GenusId, Id, PetName, Birthday FROM pet_list ORDER BY Id";
                resultSet = sqlSt.executeQuery(SQLstr);
                while (resultSet.next()) {

                    PetType type = PetType.getType(resultSet.getInt(1));
                    int id = resultSet.getInt(2);
                    String name = resultSet.getString(3);
                    LocalDate birthday = resultSet.getDate(4).toLocalDate();

                    pet = petCreator.createPet(type, name, birthday);
                    pet.setPetId(id);
                    farm.add(pet);
                }
                return farm;
            }
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            Logger.getLogger(PetRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }
    }
}

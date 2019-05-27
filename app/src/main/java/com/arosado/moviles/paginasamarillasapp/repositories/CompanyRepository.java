package com.arosado.moviles.paginasamarillasapp.repositories;

import com.arosado.moviles.paginasamarillasapp.models.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {
    private static List<Company> companies = new ArrayList<>();
    private static List<Company> companies_category;

    static {
        companies.add(new Company(
                100,
                "Hoteles",
                "Hotel Britania",
                "Avenida San Borja Sur 653 ",
                "2033900",
                "reservassanborja@hbritania.com",
                "http://www.hbritania.com",
                "ic_hotel_britania",
                "Un hotel exclusivo como Usted: Elegancia, confort y modernidad en Miraflores y San Borja."
        ));
        companies.add(new Company(
                200,
                "Hoteles",
                "Del prado Hotel",
                "Av.Pablo Carriquiry 298, San Isidro.",
                "4411700",
                "reservas@delpradohotel.com",
                "http://www.delpradohotel.com ",
                "ic_del_prado_hotel",
                "Ubicado en el distrito de San Isidro, restaurante, business center, sala adaptable para eventos."
        ));
        companies.add(new Company(
                300,
                "Farmacias",
                "Fasur Peru",
                "Avenida Goyeneche 203  Cercado de Arequipa",
                "221676",
                "administracion@farmaciafasurperu.com",
                "http://www.farmaciafasurperu.com ",
                "ic_fasur_peru",
                "Somos la única cadena farmacéutica 100% arequipeña."
        ));
        companies.add(new Company(
                400,
                "Restaurantes",
                "Arco Iris del Norte",
                "Avenida Universitaria 5356  Urb. Carabayllo ",
                "5251894",
                "chefsagitario@hotmail.com",
                "http://www.restaurantarcoirisdelnorte.com ",
                "ic_arco_iris_del_norte",
                "Especialidad en pescados y mariscos."
        ));
        companies.add(new Company(
                500,
                "Restaurantes",
                "Agueda Restaurant",
                "Avenida Collasuyo - Mz. A Lt. 1 - Cusco",
                "84224777",
                "info@agueda.com",
                "http://www.agueda.pe/",
                "ic_agueda",
                "La Mejor Carne a la parrilla al Carbón del Cusco"
        ));
        companies.add(new Company(
                600,
                "Supermercados",
                "Tottus Pachacutec",
                "Av Pachacutec 65, Distrito de Lima 15816",
                "5133355",
                "contacto@tottus.com.pe",
                "https://www.tottus.com.pe/tottus/home",
                "ic_tottus",
                "Es la cadena de supermercados chilenos perteneciente al grupo Falabella, con presencia en Chile con 60 locales y Perú con 70 locales."
        ));
        companies.add(new Company(
                700,
                "Educación",
                "Británico Surco",
                "Av. Caminos del Inca 3581, Santiago de Surco 15039",
                "6153434",
                "informes@britanico.edu.pe",
                "https://www.britanico.edu.pe/",
                "ic_britanico",
                "Conocida también como el \"BRITÁNICO\", es una asociación cultural binacional con fines de lucro que brinda la enseñanza del idioma inglés británico y que busca la promoción y el intercambio cultural entre el Reino Unido y el Perú."
        ));
        companies.add(new Company(
                800,
                "Retail",
                "Saga Falabella",
                "Av. Paseo de la República 3220 - San Isidro - Lima",
                "6161000",
                "contactenos@sagafalabella.com.pe",
                "https://www.falabella.com.pe/falabella-pe/",
                "ic_saga_falabella",
                "Es una tienda por departamentos chilena fundada en 1889 por una familia italiana radicada en Chile. Falabella cuenta con operaciones en Chile, Argentina, Perú, Colombia y Brasil."
        ));
        companies.add(new Company(
                900,
                "Petroleros",
                "Petroperú",
                "Av. Enrique Canaval Moreyra 150, Lima 27 - Perú",
                "6145000",
                "webmaster@petroperu.com.pe",
                "https://www.petroperu.com.pe/",
                "ic_petroperu",
                "Es una empresa estatal peruana dedicada al transporte, refinación, distribución y comercialización de combustibles y otros productos derivados del petróleo, que es perteneciente al Estado peruano, desde 1969."
        ));
        companies.add(new Company(
                1000,
                "Supermercados",
                "Plaza Vea Guardia Civil",
                "Av. Guardia Civi. No. 927 Urb. La Campiña",
                "6125163",
                "plazaveaonline@spsa.com.pe",
                "https://www.plazavea.com.pe/",
                "ic_plaza_vea",
                "Es una cadena de supermercados que forma parte del conglomerado peruano Intercorp, el cual también integra a los supermercados Vivanda. "
        ));
    }

    public static List<Company> getCompanies() {
        return companies;
    }

    public static Company getCompanyById(Integer id) {
        for (Company company: companies) {
            if(company.getId() == id) {
                return company;
            }
        }
        return  null;
    }

    public static List<Company> filterCompaniesByCategory(String category) {
        companies_category = new ArrayList<>();
        for (Company company : companies) {
            if(company.getCategory().equalsIgnoreCase(category)) {
                companies_category.add(company);
            }
        }
        return companies_category;
    }

}

package com.alura.challenge.conversormonedas.models;

import com.alura.challenge.conversormonedas.calculos.ConversorMonedas;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuConversionMonedas {

    Scanner scanner = new Scanner(System.in);

    private List<Moneda> monedas;
    private final ConversorMonedas conversorMonedas = new ConversorMonedas();

    double cantidad = 0;

    public void menu() {


        int opc = 0;
        int opc2 = 0;

        final String menu = """
                1. Convertir de USD a MXN
                3. Convertir de BOB a USD
                2. Convertir de ARS a USD
                4. Convertir de USD a EUR
                5. Convertir de USD a GBP
                6. Convertir de USD a JPY
                7. Otra conversión (seleccionar moneda de origen y destino)
                8. Ver historial de revisiones
                9. Salir del protgrama""";


        do {
            System.out.println("\n----------MENU DE OPCIONES---------");
            System.out.println(menu);

            try {
                opc = scanner.nextInt();

            } catch (NoSuchElementException e) {
                System.out.println("Opción no válida, ingresa un número entero válido");
                scanner.next();
                continue;
            }


            switch (opc) {
                case 1:
                    manejarOpcion1();

                    break;
                case 2:
                    manejarOpcion2();
                    break;
                case 3:
                    manejarOpcion3();
                    break;
                case 4:
                    manejarOpcion4();
                    break;
                case 5:
                    manejarOpcion5();
                    break;
                case 6:
                    manejarOpcion6();
                    break;
                case 7:
                    manejarOpcion7();
                    break;
                case 8:
                    conversorMonedas.mostrarHistorialRevisiones();
                    break;
                case 9:
                    System.out.println("Salir del programa");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }


            try{
                if(opc != 9){
                    System.out.println("¿Desea realizar otra conversión? (1. Sí / 2. No)");
                    opc2 = scanner.nextInt();
                }

                if(opc2 == 2){
                    System.out.println("Desea ver el historial de revisiones? (1. Sí / 2. No)");
                    opc2 = scanner.nextInt();
                    if(opc2 == 1) {
                        conversorMonedas.mostrarHistorialRevisiones();
                    }
                    opc = 9;
                }
               }catch (NoSuchElementException e){
                System.out.println("Opción no válida, ingresa un número entero válido");
                scanner.next();
            }


        }while (opc != 9 );

        System.out.println("Saliste del programa");
    }

    private void manejarOpcion1(){

        System.out.println("USD a MXN");
        System.out.println("Ingrese la cantidad a convertir:");
        try {
            cantidad = scanner.nextDouble();
            conversorMonedas.ConvertirMoneda("USD", "MXN", cantidad);

        } catch (NoSuchElementException e) {
            System.out.println("Cantidad no válida, ingresa un número válido\n");
            scanner.next();

        }
    }

    private void manejarOpcion2(){
            System.out.println("ARS a USD");
            System.out.println("Ingrese la cantidad a convertir:");
        try {
            cantidad = scanner.nextDouble();
            conversorMonedas.ConvertirMoneda("ARS", "USD", cantidad);
        } catch (NoSuchElementException e) {
            System.out.println("\nCantidad no válida, ingresa un número válido\n");
            scanner.next();
        }


    }

    private void manejarOpcion3(){
            System.out.println("BOB a USD");
            System.out.println("Ingrese la cantidad a convertir:");
        try {
            cantidad = scanner.nextDouble();
            conversorMonedas.ConvertirMoneda("BOB", "USD", cantidad);
        } catch (NoSuchElementException e) {
            System.out.println("Cantidad no válida, ingresa un número válido\n");
            scanner.next();
        }
    }

    private void manejarOpcion4(){
        System.out.println("USD a EUR");
        System.out.println("Ingrese la cantidad a convertir:");

        try {
            cantidad = scanner.nextDouble();
            conversorMonedas.ConvertirMoneda("USD", "EUR", cantidad);
        } catch (NoSuchElementException e) {
            System.out.println("Cantidad no válida, ingresa un número válido\n");
            scanner.next();
        }
    }

    private void manejarOpcion5(){
        System.out.println("USD a GBP");
        System.out.println("Ingrese la cantidad a convertir:");

        try {
            cantidad = scanner.nextDouble();
            conversorMonedas.ConvertirMoneda("USD", "GBP", cantidad);
        } catch (NoSuchElementException e) {
            System.out.println("Cantidad no válida, ingresa un número válido\n");
            scanner.next();
        }
    }

    private void manejarOpcion6(){
        System.out.println("USD a JPY");
        System.out.println("Ingrese la cantidad a convertir:");

        try {
            cantidad = scanner.nextDouble();
            conversorMonedas.ConvertirMoneda("USD", "JPY", cantidad);
        } catch (NoSuchElementException e) {
            System.out.println("Cantidad no válida, ingresa un número válido\n");
            scanner.next();
        }
    }

    private void manejarOpcion7(){
        System.out.println("Seleccionar moneda de origen y destino");
        System.out.println("Seleccione la moneda de origen:");
        mostrarMenuMonedas();
        int indiceMonedaOrigen = scanner.nextInt() - 1;
        String monedaOrigen = monedas.get(indiceMonedaOrigen).getCodigo();
        System.out.println("Seleccione la moneda de destino:");
        mostrarMenuMonedas();
        int indiceMonedaDestino = scanner.nextInt() - 1;
        String monedaDestino = monedas.get(indiceMonedaDestino).getCodigo();
        System.out.println("Ingrese la cantidad a convertir:");
        cantidad = scanner.nextDouble();
        conversorMonedas.ConvertirMoneda(monedaOrigen, monedaDestino, cantidad);
    }




    public   MenuConversionMonedas() {
        inicializarMonedas();
    }
    private void inicializarMonedas() {
        monedas = new ArrayList<>();
        monedas.add(new Moneda("AED", "UAE Dirham", "United Arab Emirates"));
        monedas.add(new Moneda("AFN", "Afghan Afghani", "Afghanistan"));
        monedas.add(new Moneda("ALL", "Albanian Lek", "Albania"));
        monedas.add(new Moneda("AMD", "Armenian Dram", "Armenia"));
        monedas.add(new Moneda("ANG", "Netherlands Antillian Guilder", "Netherlands Antilles"));
        monedas.add(new Moneda("AOA", "Angolan Kwanza", "Angola"));
        monedas.add(new Moneda("ARS", "Argentine Peso", "Argentina"));
        monedas.add(new Moneda("AUD", "Australian Dollar", "Australia"));
        monedas.add(new Moneda("AWG", "Aruban Florin", "Aruba"));
        monedas.add(new Moneda("AZN", "Azerbaijani Manat", "Azerbaijan"));
        monedas.add(new Moneda("BAM", "Bosnia and Herzegovina Mark", "Bosnia and Herzegovina"));
        monedas.add(new Moneda("BBD", "Barbados Dollar", "Barbados"));
        monedas.add(new Moneda("BDT", "Bangladeshi Taka", "Bangladesh"));
        monedas.add(new Moneda("BGN", "Bulgarian Lev", "Bulgaria"));
        monedas.add(new Moneda("BHD", "Bahraini Dinar", "Bahrain"));
        monedas.add(new Moneda("BIF", "Burundian Franc", "Burundi"));
        monedas.add(new Moneda("BMD", "Bermudian Dollar", "Bermuda"));
        monedas.add(new Moneda("BND", "Brunei Dollar", "Brunei"));
        monedas.add(new Moneda("BOB", "Bolivian Boliviano", "Bolivia"));
        monedas.add(new Moneda("BRL", "Brazilian Real", "Brazil"));
        monedas.add(new Moneda("BSD", "Bahamian Dollar", "Bahamas"));
        monedas.add(new Moneda("BTN", "Bhutanese Ngultrum", "Bhutan"));
        monedas.add(new Moneda("BWP", "Botswana Pula", "Botswana"));
        monedas.add(new Moneda("BYN", "Belarusian Ruble", "Belarus"));
        monedas.add(new Moneda("BZD", "Belize Dollar", "Belize"));
        monedas.add(new Moneda("CAD", "Canadian Dollar", "Canada"));
        monedas.add(new Moneda("CDF", "Congolese Franc", "Democratic Republic of the Congo"));
        monedas.add(new Moneda("CHF", "Swiss Franc", "Switzerland"));
        monedas.add(new Moneda("CLP", "Chilean Peso", "Chile"));
        monedas.add(new Moneda("CNY", "Chinese Renminbi", "China"));
        monedas.add(new Moneda("COP", "Colombian Peso", "Colombia"));
        monedas.add(new Moneda("CRC", "Costa Rican Colon", "Costa Rica"));
        monedas.add(new Moneda("CUP", "Cuban Peso", "Cuba"));
        monedas.add(new Moneda("CVE", "Cape Verdean Escudo", "Cape Verde"));
        monedas.add(new Moneda("CZK", "Czech Koruna", "Czech Republic"));
        monedas.add(new Moneda("DJF", "Djiboutian Franc", "Djibouti"));
        monedas.add(new Moneda("DKK", "Danish Krone", "Denmark"));
        monedas.add(new Moneda("DOP", "Dominican Peso", "Dominican Republic"));
        monedas.add(new Moneda("DZD", "Algerian Dinar", "Algeria"));
        monedas.add(new Moneda("EGP", "Egyptian Pound", "Egypt"));
        monedas.add(new Moneda("ERN", "Eritrean Nakfa", "Eritrea"));
        monedas.add(new Moneda("ETB", "Ethiopian Birr", "Ethiopia"));
        monedas.add(new Moneda("EUR", "Euro", "European Union"));
        monedas.add(new Moneda("FJD", "Fiji Dollar", "Fiji"));
        monedas.add(new Moneda("FKP", "Falkland Islands Pound", "Falkland Islands"));
        monedas.add(new Moneda("FOK", "Faroese Króna", "Faroe Islands"));
        monedas.add(new Moneda("GBP", "Pound Sterling", "United Kingdom"));
        monedas.add(new Moneda("GEL", "Georgian Lari", "Georgia"));
        monedas.add(new Moneda("GGP", "Guernsey Pound", "Guernsey"));
        monedas.add(new Moneda("GHS", "Ghanaian Cedi", "Ghana"));
        monedas.add(new Moneda("GIP", "Gibraltar Pound", "Gibraltar"));
        monedas.add(new Moneda("GMD", "Gambian Dalasi", "The Gambia"));
        monedas.add(new Moneda("GNF", "Guinean Franc", "Guinea"));
        monedas.add(new Moneda("GTQ", "Guatemalan Quetzal", "Guatemala"));
        monedas.add(new Moneda("GYD", "Guyanese Dollar", "Guyana"));
        monedas.add(new Moneda("HKD", "Hong Kong Dollar", "Hong Kong"));
        monedas.add(new Moneda("HNL", "Honduran Lempira", "Honduras"));
        monedas.add(new Moneda("HRK", "Croatian Kuna", "Croatia"));
        monedas.add(new Moneda("HTG", "Haitian Gourde", "Haiti"));
        monedas.add(new Moneda("HUF", "Hungarian Forint", "Hungary"));
        monedas.add(new Moneda("IDR", "Indonesian Rupiah", "Indonesia"));
        monedas.add(new Moneda("ILS", "Israeli New Shekel", "Israel"));
        monedas.add(new Moneda("IMP", "Manx Pound", "Isle of Man"));
        monedas.add(new Moneda("INR", "Indian Rupee", "India"));
        monedas.add(new Moneda("IQD", "Iraqi Dinar", "Iraq"));
        monedas.add(new Moneda("IRR", "Iranian Rial", "Iran"));
        monedas.add(new Moneda("ISK", "Icelandic Króna", "Iceland"));
        monedas.add(new Moneda("JEP", "Jersey Pound", "Jersey"));
        monedas.add(new Moneda("JMD", "Jamaican Dollar", "Jamaica"));
        monedas.add(new Moneda("JOD", "Jordanian Dinar", "Jordan"));
        monedas.add(new Moneda("JPY", "Japanese Yen", "Japan"));
        monedas.add(new Moneda("KES", "Kenyan Shilling", "Kenya"));
        monedas.add(new Moneda("KGS", "Kyrgyzstani Som", "Kyrgyzstan"));
        monedas.add(new Moneda("KHR", "Cambodian Riel", "Cambodia"));
        monedas.add(new Moneda("KID", "Kiribati Dollar", "Kiribati"));
        monedas.add(new Moneda("KMF", "Comorian Franc", "Comoros"));
        monedas.add(new Moneda("KRW", "South Korean Won", "South Korea"));
        monedas.add(new Moneda("KWD", "Kuwaiti Dinar", "Kuwait"));
        monedas.add(new Moneda("KYD", "Cayman Islands Dollar", "Cayman Islands"));
        monedas.add(new Moneda("KZT", "Kazakhstani Tenge", "Kazakhstan"));
        monedas.add(new Moneda("LAK", "Lao Kip", "Laos"));
        monedas.add(new Moneda("LBP", "Lebanese Pound", "Lebanon"));
        monedas.add(new Moneda("LKR", "Sri Lanka Rupee", "Sri Lanka"));
        monedas.add(new Moneda("LRD", "Liberian Dollar", "Liberia"));
        monedas.add(new Moneda("LSL", "Lesotho Loti", "Lesotho"));
        monedas.add(new Moneda("LYD", "Libyan Dinar", "Libya"));
        monedas.add(new Moneda("MAD", "Moroccan Dirham", "Morocco"));
        monedas.add(new Moneda("MDL", "Moldovan Leu", "Moldova"));
        monedas.add(new Moneda("MGA", "Malagasy Ariary", "Madagascar"));
        monedas.add(new Moneda("MKD", "Macedonian Denar", "North Macedonia"));
        monedas.add(new Moneda("MMK", "Burmese Kyat", "Myanmar"));
        monedas.add(new Moneda("MNT", "Mongolian Tögrög", "Mongolia"));
        monedas.add(new Moneda("MOP", "Macanese Pataca", "Macau"));
        monedas.add(new Moneda("MRU", "Mauritanian Ouguiya", "Mauritania"));
        monedas.add(new Moneda("MUR", "Mauritian Rupee", "Mauritius"));
        monedas.add(new Moneda("MVR", "Maldivian Rufiyaa", "Maldives"));
        monedas.add(new Moneda("MWK", "Malawian Kwacha", "Malawi"));
        monedas.add(new Moneda("MXN", "Mexican Peso", "Mexico"));
        monedas.add(new Moneda("MYR", "Malaysian Ringgit", "Malaysia"));
        monedas.add(new Moneda("MZN", "Mozambican Metical", "Mozambique"));
        monedas.add(new Moneda("NAD", "Namibian Dollar", "Namibia"));
        monedas.add(new Moneda("NGN", "Nigerian Naira", "Nigeria"));
        monedas.add(new Moneda("NIO", "Nicaraguan Córdoba", "Nicaragua"));
        monedas.add(new Moneda("NOK", "Norwegian Krone", "Norway"));
        monedas.add(new Moneda("NPR", "Nepalese Rupee", "Nepal"));
        monedas.add(new Moneda("NZD", "New Zealand Dollar", "New Zealand"));
        monedas.add(new Moneda("OMR", "Omani Rial", "Oman"));
        monedas.add(new Moneda("PAB", "Panamanian Balboa", "Panama"));
        monedas.add(new Moneda("PEN", "Peruvian Sol", "Peru"));
        monedas.add(new Moneda("PGK", "Papua New Guinean Kina", "Papua New Guinea"));
        monedas.add(new Moneda("PHP", "Philippine Peso", "Philippines"));
        monedas.add(new Moneda("PKR", "Pakistani Rupee", "Pakistan"));
        monedas.add(new Moneda("PLN", "Polish Złoty", "Poland"));
        monedas.add(new Moneda("PYG", "Paraguayan Guaraní", "Paraguay"));
        monedas.add(new Moneda("QAR", "Qatari Riyal", "Qatar"));
        monedas.add(new Moneda("RON", "Romanian Leu", "Romania"));
        monedas.add(new Moneda("RSD", "Serbian Dinar", "Serbia"));
        monedas.add(new Moneda("RUB", "Russian Ruble", "Russia"));
        monedas.add(new Moneda("RWF", "Rwandan Franc", "Rwanda"));
        monedas.add(new Moneda("SAR", "Saudi Riyal", "Saudi Arabia"));
        monedas.add(new Moneda("SBD", "Solomon Islands Dollar", "Solomon Islands"));
        monedas.add(new Moneda("SCR", "Seychellois Rupee", "Seychelles"));
        monedas.add(new Moneda("SDG", "Sudanese Pound", "Sudan"));
        monedas.add(new Moneda("SEK", "Swedish Krona", "Sweden"));
        monedas.add(new Moneda("SGD", "Singapore Dollar", "Singapore"));
        monedas.add(new Moneda("SHP", "Saint Helena Pound", "Saint Helena"));
        monedas.add(new Moneda("SLE", "Sierra Leonean Leone", "Sierra Leone"));
        monedas.add(new Moneda("SOS", "Somali Shilling", "Somalia"));
        monedas.add(new Moneda("SRD", "Surinamese Dollar", "Suriname"));
        monedas.add(new Moneda("SSP", "South Sudanese Pound", "South Sudan"));
        monedas.add(new Moneda("STN", "São Tomé and Príncipe Dobra", "São Tomé and Príncipe"));
        monedas.add(new Moneda("SYP", "Syrian Pound", "Syria"));
        monedas.add(new Moneda("SZL", "Eswatini Lilangeni", "Eswatini"));
        monedas.add(new Moneda("THB", "Thai Baht", "Thailand"));
        monedas.add(new Moneda("TJS", "Tajikistani Somoni", "Tajikistan"));
        monedas.add(new Moneda("TMT", "Turkmenistan Manat", "Turkmenistan"));
        monedas.add(new Moneda("TND", "Tunisian Dinar", "Tunisia"));
        monedas.add(new Moneda("TOP", "Tongan Paʻanga", "Tonga"));
        monedas.add(new Moneda("TRY", "Turkish Lira", "Turkey"));
        monedas.add(new Moneda("TTD", "Trinidad and Tobago Dollar", "Trinidad and Tobago"));
        monedas.add(new Moneda("TVD", "Tuvaluan Dollar", "Tuvalu"));
        monedas.add(new Moneda("TWD", "New Taiwan Dollar", "Taiwan"));
        monedas.add(new Moneda("TZS", "Tanzanian Shilling", "Tanzania"));
        monedas.add(new Moneda("UAH", "Ukrainian Hryvnia", "Ukraine"));
        monedas.add(new Moneda("UGX", "Ugandan Shilling", "Uganda"));
        monedas.add(new Moneda("USD", "United States Dollar", "United States"));
        monedas.add(new Moneda("UYU", "Uruguayan Peso", "Uruguay"));
        monedas.add(new Moneda("UZS", "Uzbekistani So'm", "Uzbekistan"));
        monedas.add(new Moneda("VES", "Venezuelan Bolívar Soberano", "Venezuela"));
        monedas.add(new Moneda("VND", "Vietnamese Đồng", "Vietnam"));
        monedas.add(new Moneda("VUV", "Vanuatu Vatu", "Vanuatu"));
        monedas.add(new Moneda("WST", "Samoan Tālā", "Samoa"));
        monedas.add(new Moneda("XAF", "Central African CFA Franc", "CEMAC"));
        monedas.add(new Moneda("XCD", "East Caribbean Dollar", "Organisation of Eastern Caribbean States"));
        monedas.add(new Moneda("XDR", "Special Drawing Rights", "International Monetary Fund"));
        monedas.add(new Moneda("XOF", "West African CFA franc", "CFA"));
        monedas.add(new Moneda("XPF", "CFP Franc", "Collectivités d'Outre-Mer"));
        monedas.add(new Moneda("YER", "Yemeni Rial", "Yemen"));
        monedas.add(new Moneda("ZAR", "South African Rand", "South Africa"));
        monedas.add(new Moneda("ZMW", "Zambian Kwacha", "Zambia"));
        monedas.add(new Moneda("ZWL", "Zimbabwean Dollar", "Zimbabwe"));
    }

    public void mostrarMenuMonedas() {
        for (int i = 0; i < monedas.size(); i++) {
            System.out.println((i + 1) + " . " + monedas.get(i));
        }


    }

}

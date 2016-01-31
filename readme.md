# JEE - EJB Aufgaben

## Stateless session Bean
1) Erstellen Sie ein einfaches EJB-Projekt in welchem Sie eine neue Session-Bean `Calculator` erstellen.

Die Session Bean sollte das folgende Interface implementieren:
~~~
/**
 * Ein Rechner für Ganzzahlige Berechnungen
 */
public interface CalculatorRemote {

	public abstract int add(int a, int b);

	public abstract int multiply(int a, int b);

	public abstract int divide(int a, int b) throws CaclulatorException;

}
~~~

2) Erstellen Sie dazu passend ein Web-Client, mit einem Formular, welcher die entsprechende Bean benutzt. Erstellen Sie Hierzu ein neues Web-Projekt.

3) Erstellen Sie zudem eine Java-SE-Anwendung mit `main()`-Methode, welche die Session-Bean nutzt. (Hier kann auf Interaktion mit dem Anwender verzichtet werden).

## Stateful Session Bean
 1) Erstellen Sie eine weitere Session Bean, welche das folgende Interface implementiert.
~~~
/**
 * Ein Rechner für Ganzzahlige Berechnungen mit Protokolfunktion
 */
 public interface RecordingCalculatorRemote {

 	int add(int a);

 	int multiply(int a);

 	int divide(int a) throws CaclulatorException;

  /**
   * Gibt eine Liste mit allen bisherigen Operationen des Objects zurück
   */
 	List<String> getProtocol();

 	int getValue();

 }
~~~
2 ) Erweitern Sie ihre Webanwendung um ein Formular zur Nutzung eines RecordingCalculators. Was muss passieren, wenn der Rechner zurückgesetzt werden soll?

3) Erstellen Sie eine weitere Java-SE-Anwendung welche verschiedene Instanzen des
`RecordingCalculator` nutzt. Was passiert im EBJ-Container wenn eine neue Referenz angefordert wird.

## Technische Hinweise zum Projekt

### sample-ejb-calculatorSeClient
Das Projekt referenziert die *gf-client-jar*-Bibliothek, welche im *lib* Pfad des Glassfish-Servers liegen sollte. Der import muss vor der Start der Anweundungen entsprechende der lokalen Gegebenheiten angepasst werden.

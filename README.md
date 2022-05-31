# Spring boot vježba
**1. CRUD Mongo**  
- Kreiranje Student entitet-a i implementacija CRUD operacija.
- Kreiranje Custom query-a koristeći MongoTemplate ili Repository klasu.

**2. Migracije**
- Kreiranje migracija koristeći Mongock.

**3. REST template**
- Dohvaćanje i modeliranje podataka sa Api-a, koristeći Rest template.

**4. HTTP Client**
- Koristeći http client kreirati web scraper koji će dohvaćati brojeve(rezultate izvlačenja) sa lotto stranica te ih prikazati.

**5. Rabbit**
- Konfigurirati Exchange-ve, Queue-eve te binding-e. Kreirati Rest controller koji će handle-ati slanje poruka na queue-eve.

**6. Websocket**
- Konfigurirati Websocket Message broker te endpoint za slanje poruka na subscribe-ere.

**7. Scheduler/Caching**
- Kreirati komponente koje koriste Scheduling određenih radnjih.
- Caching lotto komponente (koja će vaditi rezultate iz cache-a svakih 10 sekundi, a nakon 60 sekundi očistiti cache i ići po nove podatke).


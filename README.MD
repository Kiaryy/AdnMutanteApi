# Repo para la api del primer parcial prog 3
## Martin Moron

## Cloning and using the repository locally
```bash
  git clone https://github.com/Kiaryy/AdnMutanteApi.git
  cd AdnMutanteApi
  ./gradlew build
  ./gradlew bootrun
```

## API Functionality:
- *POST:* Checks a DNA sequence is mutant or not, and then saves the results in db.
  - URL: https://dnamutantapi-latest.onrender.com/mutant
  
- *GET:* Returns mutant and human statistics.
  - URL: https://dnamutantapi-latest.onrender.com/stats
## Example of POST Request:
 ```
  {
    "dna": [ "AGCCCT",
    "CATTGC",
    "TATTGT",
    "AGATGG",
    "TACACT",
    "TCACTG"]
  }
 ```


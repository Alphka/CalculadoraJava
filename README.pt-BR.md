<h1 align="center">Calculadora</h1>

<p align="center">
	<a href="README.md">English</a> | Português (Brasil)
</p>

### Descrição

Uma calculadora simples para Android, escrita em Java. Ela recebe dois números e aplica uma de quatro operações: soma, subtração, multiplicação ou divisão.

Este aplicativo foi desenvolvido como parte dos requisitos parciais para a disciplina de Introdução a Programação do Instituto Federal do Norte de Minas Gerais (IFNMG) no curso Técnico em Informática para Internet.

> [!NOTE]
> A interface está apenas em português do Brasil (`app/src/main/res/values/strings.xml`); não há outras traduções.

### Funcionalidades

- Dois campos numéricos (primeiro e segundo número).
- Escolha da operação por botões de opção: somar, subtrair, dividir e multiplicar.
- Validação: campos vazios exibem um erro no próprio campo, e a divisão por zero exibe uma mensagem no lugar do resultado.
- O separador decimal segue a localidade do dispositivo (a vírgula é convertida em ponto antes da conversão).
- Resultados inteiros são exibidos sem o sufixo `.0`.

### Capturas de tela

<p align="center">
	<img src=".github/Screenshot_20240503_173500.png" alt="Tela principal" width="300">
</p>

### Tecnologias

- Java (compatibilidade 1.8) e Android, com as bibliotecas AppCompat, Material Components (1.12.0) e ConstraintLayout
- Gradle 8.2 com Android Gradle Plugin 8.2.2

| Configuração | Valor |
|---|---|
| Application ID | `com.kayo.calc` |
| `minSdk` | 29 (Android 10) |
| `targetSdk` | 30 |
| `compileSdk` | 34 |

### Requisitos

- [Android Studio](https://developer.android.com/studio), ou o Android SDK com JDK 17 (exigido pelo Android Gradle Plugin 8.2)
- Um dispositivo ou emulador com Android 10 (API 29) ou superior

### Como executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/Alphka/CalculadoraJava.git
   ```

2. Abra o projeto no Android Studio e aguarde a sincronização do Gradle.
3. Selecione um dispositivo ou emulador e execute a configuração `app`.

Para gerar um APK de debug pela linha de comando (requer o Android SDK, com `ANDROID_HOME` ou `local.properties` configurado):

```bash
./gradlew assembleDebug
```

### Testes

O repositório contém apenas os testes padrão do template (`ExampleUnitTest` e `ExampleInstrumentedTest`); não há testes para a lógica da calculadora.

### Licença

[ISC](LICENSE.md) © 2024 Kayo Souza

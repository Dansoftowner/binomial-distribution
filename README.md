# Binomial expansion calculator

Simple application that implements the [Binomial theorem](https://en.wikipedia.org/wiki/Binomial_theorem) 
mathematical pattern.

## Run CLI App

```
gradlew :cli:run -q --console=plain
```

### Character encoding problems
Since the app uses special unicode characters for displaying the exponent numbers, your terminal might not display them 
correctly if wrong charset is used. 

In the Windows Command Prompt, you can set your charset to UTF-8 with this:
```
chcp 65001
```

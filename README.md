# Flight Control App
Aplicativo para controle de Voos.

## Resumo

Através desse aplicativo é possível vizualizar cada voo de uma companhia aerea e ter uma visão geral dos voos com base nos status.

## Sobre o projeto

Desenvolvido no Android Studio utilizando a linguagem de programação Kotlin.

## Testes automatizados

Foram feitos teste automatizatos utilizando mockito e junit. Os testes foram criados para validar as funções existentes nas ViewModels.

## Bibliotecas utilizadas

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Dependency Injection
    implementation(libs.koin.android)
    //Chart
    implementation(libs.mpandroidchart)

    //Test
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlinx.coroutines.test.v171)
    testImplementation(libs.androidx.core.testing)

## Tela home

<img src="https://github.com/user-attachments/assets/42ecce50-ad86-40fe-8315-d5c6922e3a5e" alt="Descrição da Imagem" width="200">

## Tela dos Voos

<img src="https://github.com/user-attachments/assets/f23f026f-e5c8-49d3-8211-b150ce9e15a4" alt="Descrição da Imagem" width="200">
<img src="https://github.com/user-attachments/assets/1d2779dd-23c9-4470-9640-0da47fc4c244" alt="Descrição da Imagem" width="200">

## Tela para adicionar novo voo

<img src="https://github.com/user-attachments/assets/a6cc5ad5-deb6-46e2-9878-12c7c4b8b33d" alt="Descrição da Imagem" width="200">

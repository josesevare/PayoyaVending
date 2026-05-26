# 🧀 La Payoya Vending: Software de Gestión Láctea

[![Java Version](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Environment](https://img.shields.io/badge/Environment-GitHub_Codespaces-blue.svg)](https://github.com/features/codespaces)
[![Docs](https://img.shields.io/badge/Docs-GitHub_Pages-green.svg)](https://pages.github.com/)

Este proyecto nace para resolver el reto de la **Asociación de Productores de la Sierra de Cádiz/Málaga**: modernizar la venta de productos de cabra payoya (leche, nata y queso) mediante máquinas expendedoras inteligentes operativas las 24 horas.

---

## 🚀 Características Principales

- **Entorno Cloud-Native:** Desarrollo exclusivo en **GitHub Codespaces** para garantizar paridad de entornos.
- **Gestión de Inventario Inteligente:** Control de stock para productos envasados (queso) y dispensadores por volumen (leche y nata).
- **Lógica de Pagos Estricta:**
  - Acepta monedas desde 0,50€.
  - Límite de billetes de hasta 5,00€.
  - Integración simulada con terminal de tarjeta bancaria.
- **Sistema de Alertas:** Notificaciones automáticas al supervisor y al usuario final cuando se agota el stock.
- **Documentación Dinámica:** Portafolio técnico desplegado en **GitHub Pages** mediante Markdown.

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java 17
- **Infraestructura:** GitHub Codespaces
- **Documentación:** Markdown & GitHub Pages
- **Gestión de Proyecto:** Roles jerárquicos (Arquitecto, Desarrollador, Documentalista)

---

## 📦 Estructura del Proyecto

```text
├── .devcontainer/          # Configuración del entorno de Codespaces
├── src/
│   └── PayoyaVending.java  # Lógica principal del programa
├── docs/
│   └── index.md            # Documentación técnica para GitHub Pages
└── README.md               # Este archivo
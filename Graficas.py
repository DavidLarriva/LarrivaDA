
#CODIGO PARA GENERAR GRAFICAS CON MATPLOTLIB

import matplotlib.pyplot as plt
import matplotlib
matplotlib.use("TkAgg")  


tamanos = [10, 100, 1000, 5000, 10000, 30000]
tiempos_busquedas = {
    "Busqueda Binaria Normal": [0.000004000, 0.000001200, 0.000001600, 0.000001900, 0.000002000, 0.000001800],
    "Busqueda Binaria Recursiva": [0.000013600, 0.000003400, 0.000002200, 0.000001900, 0.000002200, 0.000002000],
}


for metodo, tiempos_metodo in tiempos_busquedas.items():
    plt.figure(figsize=(8, 5))  
    plt.bar([str(t) for t in tamanos], tiempos_metodo, color="skyblue", alpha=0.8)
    plt.title(f"Tiempo de ejecucion del metodo {metodo}", fontsize=14)
    plt.xlabel("Cantidad de Valores", fontsize=12)
    plt.ylabel("Tiempo (segundos)", fontsize=12)
    plt.yscale("log")  
    plt.grid(True, which="both", linestyle="--", linewidth=0.7)
    plt.tight_layout()
    plt.savefig(f"{metodo.replace(' ', '_')}.png")  
    plt.show()  

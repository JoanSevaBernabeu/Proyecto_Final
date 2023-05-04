using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Proyecto
{
    class CustomCommands
    {
        public static readonly RoutedUICommand Cancelar = new RoutedUICommand(
            "Cancelar",
            "Cancelar",
            typeof(CustomCommands),
            new InputGestureCollection
            {
                new KeyGesture(Key.C,ModifierKeys.Control)
            }
            );
        public static readonly RoutedUICommand Salir = new RoutedUICommand(
            "Salir",
            "Salir",
            typeof(CustomCommands),
            new InputGestureCollection
            {
                new KeyGesture(Key.S,ModifierKeys.Control)
            }
            );
        public static readonly RoutedUICommand HabNueva = new RoutedUICommand(
            "HabNueva",
            "HabNueva",
            typeof(CustomCommands),
            new InputGestureCollection
            {
                new KeyGesture(Key.H,ModifierKeys.Control)
            }
            );
        public static readonly RoutedUICommand TratNuevo = new RoutedUICommand(
            "TratNuevo",
            "TratNuevo",
            typeof(CustomCommands),
            new InputGestureCollection
            {
                new KeyGesture(Key.T,ModifierKeys.Control)
            }
            );
        public static readonly RoutedUICommand MedicamentoNuevo = new RoutedUICommand(
            "MedicamentoNuevo",
            "MedicamentoNuevo",
            typeof(CustomCommands),
            new InputGestureCollection
            {
                new KeyGesture(Key.M,ModifierKeys.Control)
            }
            );
        public static readonly RoutedUICommand MedicoNuevo = new RoutedUICommand(
            "MedicoNuevo",
            "MedicoNuevo",
            typeof(CustomCommands),
            new InputGestureCollection
            {
                new KeyGesture(Key.E,ModifierKeys.Control)
            }
            );

    }
}

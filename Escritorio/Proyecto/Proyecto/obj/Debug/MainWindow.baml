   M S B A M L   `   `   `  ����C  ?Proyecto, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null#clr-namespace:ProyectoProyecto  5   	       Proyecto.MainWindow   5   	   W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   (localclr-namespace:Proyecto     5   	     � Title$  GestiMed��5   	   $	��900��6   $
��1600��6'    J� CommandBindings 5	      )  #System.Windows.Input.CommandBinding  5
   
   -   5           Command$# local:CustomCommands.Cancelar��5
      5   F     5   
   -   5        $  local:CustomCommands.Salir��5      5   C     5   
   -   5        $# local:CustomCommands.HabNueva��5      5   M     5   
   -   5        $- 'local:CustomCommands.EliminarHabitacion��5      5   P     5   
   -   5        $$ local:CustomCommands.TratNuevo��5      5   N     5   
   -   5        $. (local:CustomCommands.EliminarTratamiento��5      5   Q     5   
   -   5        $+ %local:CustomCommands.MedicamentoNuevo��5      5   N     5   
   -   5        $. (local:CustomCommands.EliminarMedicamento��5      5   Q     5   
   -	   5        $&  local:CustomCommands.MedicoNuevo��5      5   I     5   
   -
   5        $) #local:CustomCommands.EliminarMedico��5      5   L     5   
   -   5        $( "local:CustomCommands.PacienteNuevo��5      5   K     5    
   -   5        $+ %local:CustomCommands.EliminarPaciente��5       5!   N    � 	Resources 5#       �� 
TargetType   baseMenuItem �� Property �� Value  
baseButton��%�  &	        &	 �     �� 5$   
   " m�6   .�5%      ��  � ��$ 	_Cancelar��6'   �� 5&       �@m�InputGestureText$ Ctrl + C��61   �� 5'       �@m�Command$# local:CustomCommands.Cancelar��6(   5(      �� 5)   
   " ��6   .�5*      ��  � ��$ Center=�64   �� 5+       � ��$ 40q�6'   �� 5,       � ��$	 100��6&   �� 5-       � ��$ 30��6'   5.      5/      .��50      ]� .+�51   
   o� $	��Top=�6   
�������.@�52      m� $��	Pacientes��6   .@�53      m� $��Paciente nuevo...��6    m� InputGestureText$ Ctrl + P��66    m� Command$( "local:CustomCommands.PacienteNuevo��6R   m� 54      $��Eliminar Paciente...��6   $ Ctrl + N��69   $+ %local:CustomCommands.EliminarPaciente��6U   m� 55      #��[  6   56      m� 57      $��Habitaciones��6   .@�58      m� $��_Habitacion nueva...��6   $ Ctrl + H��69   $# local:CustomCommands.HabNueva��6U   m� 59      $��Eliminar Habitacion...��6   $ Ctrl + A��6;   $- 'local:CustomCommands.EliminarHabitacion��6W   m� 5:      #��[  6   5;      m� 5<      $��Tratamiento��6   .@�5=      m� $��_Tratamiento nuevo...��6   $ Ctrl + T��6:   $$ local:CustomCommands.TratNuevo��6V   m� 5>      $��Eliminar Tratamiento...��6   $ Ctrl + R��6<   $. (local:CustomCommands.EliminarTratamiento��6X   m� 5?      #��[  6   5@      m� 5A      $��Medicamentos��6   .@�5B      m� $��_Medicacion nueva...��6   $ Ctrl + M��69   $+ %local:CustomCommands.MedicamentoNuevo��6U   m� 5C      $��Eliminar Medicacion...��6   $ Ctrl + D��6;   $. (local:CustomCommands.EliminarMedicamento��6W   m� 5D      #��[  6   5E      m� 5F      $��Medicos��6   .@�5G      m� $��M_edico Nuevo...��6   $ Ctrl + E��65   $&  local:CustomCommands.MedicoNuevo��6Q   m� 5H      $��Eliminar Medico...��6   $ Ctrl + I��67   $) #local:CustomCommands.EliminarMedico��6S   m� 5I      #��[  6   5J      5K      �� 5L   
   -   5        $��Bottom=�5L      $��Salir��6)   #��[ 69   6]   �� 5M   
   $��/src/logo2.png��6   $��20q�6(   5N      5O      
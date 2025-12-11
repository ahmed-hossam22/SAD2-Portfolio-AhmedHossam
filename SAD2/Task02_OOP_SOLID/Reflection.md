# Reflection – Task 02 (OOP & SOLID)

## What I Learned
Through this task, I learned how applying SOLID principles can significantly improve system structure and maintainability.  
The **Single Responsibility Principle (SRP)** helped me understand why separating responsibilities into dedicated classes makes the system easier to extend and test.  
The **Open/Closed Principle (OCP)** showed me how interfaces allow new behaviors to be added without modifying existing code, which improves flexibility and reduces future errors.

## Challenges Faced
One of the main challenges was deciding where responsibilities should be separated, especially when identifying what belongs inside each class.  
Designing the `Schedule` interface and ensuring that both implementations (`SimpleSchedule` and `DoctorSchedule`) worked correctly without modifying unrelated classes required careful planning.  
Another challenge was ensuring that Admin and Doctor interactions still worked smoothly after applying SRP and OCP.

## Improvements Made
- Extracted ID validation logic into `IdValidator`, which follows SRP.
- Introduced the `Schedule` interface with multiple implementations, supporting OCP.
- Reduced coupling by making classes depend on abstractions instead of concrete implementations.

## Future Enhancements
- Add more schedule types (e.g., WeeklySchedule, ShiftSchedule) to fully utilize OCP.
- Improve error handling and input validation.
- Add unit tests to verify the behavior of each schedule implementation.
- Expand the UML with sequence diagrams for system flows such as booking appointments.

## Conclusion
This task helped me understand how SOLID principles make an application more modular, predictable, and easier to extend.  
By restructuring parts of the hospital system using SRP and OCP, the final design became cleaner, more scalable, and more maintainable.

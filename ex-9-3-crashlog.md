```bash
***************************
APPLICATION FAILED TO START
***************************

Description:

The dependencies of some of the beans in the application context form a cycle:

   orderAdapter defined in file [/home/pinnheads/Work/da-25-26/target/classes/com/da/da_25_26/order/OrderAdapter.class]
      ↓
   orderFacade defined in file [/home/pinnheads/Work/da-25-26/target/classes/com/da/da_25_26/order/OrderFacade.class]
┌─────┐
|  orderService defined in file [/home/pinnheads/Work/da-25-26/target/classes/com/da/da_25_26/order/OrderService.class]
↑     ↓
|  userService defined in file [/home/pinnheads/Work/da-25-26/target/classes/com/da/da_25_26/users/UserService.class]
└─────┘


Action:

Relying upon circular references is discouraged and they are prohibited by default. Update your application to remove the dependency cycle between beans. As a last resort, it may be possible to break the cycle automatically by setting spring.main.allow-circular-references to true.
```
```
```

## Explanation
The application fails to start because of Circular Dependency.
- Spring tries to create `OrderService`
- Then in the constructor is sees the `UserService`
- Then it tries to create `UserService`
- In the constructor of that file it sees `OrderService` again.

So neither can finish initialization because they require the other service to be fully ready before they can exist.

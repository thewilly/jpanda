# jpanda
JPanda is a light distributed parallel computing framework for java.

## How it works
You just have to deploy a master node and a bunch of slave node. The rest is done by the framework. It allows things like this:

```java

int[] bigData = new int[Integer.MAX_INT];

// bigData = ... fill with random integers...

Function squares = (number) -> return number*number;

Job job = new Job("compute-squares", bigData, squares);

JpandaClient jpanda = new JpandaClient(MASTER_IP, MASTER_PORT);

jpanda.submmitJob(job);

// Do watever you want here...

while(!jpanda.isJobDone("compute-squares")) {
  // Example on how to wait for job to complete
}

// When calling getResults, depending on your client you can wait for them to be ready or get and exception if they are not ready.
int[] result = jpanda.getResultsForJob("compute-squares");

````

### Why JPanda?
J cames from Java of course and Panda from Parallel Distributed Architecture, JPDA would be much much boring dont you think?

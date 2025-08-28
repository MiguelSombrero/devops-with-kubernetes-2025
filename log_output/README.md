# Log output exercise

## Deploy to Kubernetes

Deploy recursively all resources (configmap, namespace, pvc, log-output-app, ping-pong-app)

```bash
kubectl apply -R -f manifests/
```

NOTICE: If there is also "the project" deployed, it's ingress may clash with this one. You can delete ingress defore deploying by:

```bash
kubectl delete ing todo-ing -n project
```

## Use

Call API when running in k3d cluster:

### To increment ping pongs:

```bash
    curl http://localhost:8081/pingpong
```

### To fetch logs and ping pong:

```bash
    curl http://localhost:8081/
```

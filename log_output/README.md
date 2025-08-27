# Log output exercise

## Deploy to Kubernetes

Deploy recursively all resources (namespace, pvc, log-output-app, ping-pong-app)

```bash
kubectl apply -R -f manifests/
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

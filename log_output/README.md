# Log output exercise

## Deploy to Kubernetes

### Deploy persistent volumes

```bash
kubectl apply -f infra/manifests
```

### Deploy log-output-app

```bash
kubectl apply -f log-output-app/manifests
```

NOTICE: this will also apply mutual ingress for log-output-app and ping-pong-app.

### Deploy ping-pong-app

```bash
kubectl apply -f ping-pong-app/manifests
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
